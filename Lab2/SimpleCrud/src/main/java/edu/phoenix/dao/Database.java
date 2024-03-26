package edu.phoenix.dao;

import edu.phoenix.dao.errors.IncorrectPasswordException;
import edu.phoenix.dao.errors.UserExistsException;
import edu.phoenix.dao.errors.UserNotFoundException;
import edu.phoenix.model.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
  public static List<User> dataBase = new ArrayList<>();

  public static void addUser(String name, String login, String password) throws UserExistsException {
    // Проверяем, существует ли пользователь с таким логином
    for (User user : dataBase) {
      if (user.getLogin().equals(login)) {
        throw new UserExistsException("User with this login already exists.");
      }
    }

    // Если пользователя с таким логином нет, то добавляем нового пользователя в базу данных
    User newUser = new User(name, login, password);
    dataBase.add(newUser);
  }

  public static User getUser(String login, String password) throws UserNotFoundException, IncorrectPasswordException {
    // Ищем пользователя по логину
    for (User user : dataBase) {
      if (user.getLogin().equals(login)) {
        // Если нашли пользователя, проверяем пароль
        if (user.getPassword().equals(password)) {
          return user; // Возвращаем пользователя, если пароль совпадает
        } else {
          throw new IncorrectPasswordException("Incorrect password.");
        }
      }
    }

    // Если не нашли пользователя, выбрасываем исключение
    throw new UserNotFoundException("User not found.");
  }

  public static void deleteUser(String login) throws UserNotFoundException {
    // Ищем пользователя по логину и удаляем его
    for (User user : dataBase) {
      if (user.getLogin().equals(login)) {
        dataBase.remove(user);
        return;
      }
    }

    // Если не нашли пользователя, выбрасываем исключение
    throw new UserNotFoundException("User not found.");
  }

  public static void updateUser(User user) throws UserNotFoundException {
    // Ищем пользователя по логину и обновляем информацию
    boolean found = false;
    for (int i = 0; i < dataBase.size(); i++) {
      if (dataBase.get(i).getLogin().equals(user.getLogin())) {
        dataBase.set(i, user);
        found = true;
        break;
      }
    }

    // Если не нашли пользователя, выбрасываем исключение
    if (!found) {
      throw new UserNotFoundException("User not found.");
    }
  }
}

