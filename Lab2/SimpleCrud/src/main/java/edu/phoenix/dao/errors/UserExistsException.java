package edu.phoenix.dao.errors;

public class UserExistsException extends Exception {
    public UserExistsException(String message) {
        super(message);
    }
}
