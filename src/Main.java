import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Person user = new Person();
        user.name = "Johana";
        user.age = 28;
        user.weight = 70.1f;
        int k;
        int counter = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce the number of calculators");
        int numberCalculator = scanner.nextInt();

        for (int i = 1; i <= numberCalculator; i++) {
            Calculator calculatorNew = new Calculator(); // creando un objeto o una instacia de calculator
            calculatorNew.name = "name " + i; // guardar datos en un string accediendo a el objeto
            user.calculators.add(calculatorNew); // guardando cada elemento en el array calculatorNew
        }

        Scanner scanner1 = new Scanner(System.in);
        System.out.println(" 1. Add a calculator\n 2.Remove a calculator");
        int numberUser = scanner.nextInt();

        if (numberUser == 1) {
            Calculator calculatorNewAdd = new Calculator(); // creando un objeto o una instacia de calculator
            System.out.println("Introduce the name of calculators");
            calculatorNewAdd.name = scanner.next();
            user.calculators.add(calculatorNewAdd);
        } else if (numberUser == 2) {
            System.out.println("Enter the name of the calculator you want to remove ");
            String nameRemove = scanner1.nextLine();
            boolean removed = false;
            for (k = 0; k < user.calculators.size(); k++) {
                if (user.calculators.get(k).name.equals(nameRemove)) {
                    user.calculators.remove(k);
                    removed = true;
                }
            }
            if (removed) {
                System.out.println("It has been deleted " + "(" + nameRemove + ")");
            } else {
                System.out.println("The calculator not exit");
            }
        }
        for (int r = 0; r < user.calculators.size(); r++) {
            user.calculators.get(r).printInfo();
        }
    }
}


class Person {
    String name;
    int age;
    float weight;

    ArrayList<Calculator> calculators = new ArrayList<>(); // declaracion de una lista de array y su parametro es (arraylista) array..

    Person() {
    }

    void eat() {
        System.out.println("Eating...");
    }

    void sleep() {
        System.out.println("Sleeping...");
    }

    void printInfo() {
        System.out.println("My name is " + name + ", I'm " + age + ", and my weight is " + weight);
    }
}

class Calculator {
    String name;

    Calculator() {

    }

    void printInfo() {
        System.out.println("Mi nombre es " + name);

    }
}





