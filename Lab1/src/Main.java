public class Main {
    public static void main(String[] args) {

        Cat myCat = new Cat("Filler", 3, "Chileshe Abraham");

        System.out.println("Cat Name: " + myCat.getName());
        System.out.println("Age: " + myCat.getAge());
        System.out.println("Owner: " + myCat.getOwnerName());

        myCat.meow();
        myCat.drinkMilk();
        myCat.jump();


    }
}