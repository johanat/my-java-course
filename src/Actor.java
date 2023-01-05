public class Actor {
    private String name;
    private int age;

    Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void act() {
        System.out.println("The author " + name + " is acting in a movie");
    }

    @Override
    public String toString() {
        return  name ;
    }
}


