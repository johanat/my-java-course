import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person johana = new Person("Johana", 5);
        Person darwin = new Person("Darwin", 35);

        johana.eat();
    }
}

class Person {

    String name;
    int age;
    float weight = 90; //Peso

    Person(String paraName, int paramAge){
        this.name = paraName;
        this.age = paramAge;
    }

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