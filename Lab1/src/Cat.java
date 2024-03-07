public class Cat {
    static String name;
    private int age;
    private String ownerName;

    //Class Constructor
    public Cat(String name, int age, String ownerName ){
        this.name = name;
        this.age = age;
        this.ownerName = ownerName;
    }
    //Class Constructor --------

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public void jump(){
        System.out.println(name + " is jumping");
    }
    public void drinkMilk(){
        System.out.println(name + " is drinking milk");
    }
    public void meow(){
        System.out.println("Meowwww!!!");
    }
}
