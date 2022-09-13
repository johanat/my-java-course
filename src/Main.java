import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int number;
        int index;
        System.out.println("Introduce a number from 1 to 5");
        number = scanner.nextInt();
        if (number <= 5) {
            for (int i = 0; i < number; i++) {
                System.out.println("Introduce your name");
                String name = scanner.next();
                System.out.println("Introduce your age");
                int age = scanner.nextInt();
                System.out.println("Introduce your weight");
                float weight = scanner.nextFloat();

                Person person1 = new Person(name, age, weight); // Creando una instancia, pasa parametros al contructor.
                people.add(person1);
            }
        } else {
            System.out.println("Number invalid");
        }

        printPeopleArray(people);

        System.out.println("\n Which user do you want to modify?, introduce a index");
        index = scanner.nextInt();

        System.out.println("Introduce your name");
        people.get(index).name = scanner.next();
        System.out.println("Introduce your age");
        people.get(index).age = scanner.nextInt();
        System.out.println("Introduce your weight");
        people.get(index).weight = scanner.nextFloat();

        printPeopleArray(people);

    }
    static void printPeopleArray(ArrayList<Person> people) {
        for (int k = 0; k < people.size(); k++) {
            System.out.println("persona" + k);
            people.get(k).printInfo();
        }
    }
}

class Person {
    String name;
    int age;
    float weight;

    Person(String name, int age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    void printInfo() {
        System.out.println("\nMy name is " + name.toUpperCase() + " I am age  " + age + " and my weight is " + weight);
    }
}
