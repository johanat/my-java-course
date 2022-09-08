import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Person johana = new Person();
        Person darwin = new Person();

        johana.name = "Johana";
        johana.age = 28;
        johana.weight = 70.0F;

        darwin.name = "Darwin";
        darwin.age = 34;
        darwin.weight = 63.0F;

        //johana.printInfo();
        //darwin.printInfo();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce your name:");
        String name = scanner.nextLine();
        johana.name = name;

        System.out.println("Introduce your age:");
        johana.age = scanner.nextInt();

        System.out.println("Your weight:");
        johana.weight = scanner.nextFloat();

        johana.printInfo();

    }
}

class Person {

    String name;
    int age;
    float weight; //Peso

    Person(){}

    void eat() {
        System.out.println("Eating...");
    }

    void sleep() {
        System.out.println("Sleeping...");
    }

    void printInfo() {
        System.out.println("My name is " + name + ", I'm "+ age + ", and my weight is " + weight);
    }
}