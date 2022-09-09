import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car(); // myCar es una instancia de car

        String color;
        String model;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce the color at car  ");
        color = scanner.nextLine();
        myCar.color = color;

        System.out.println("Introduce the  car model");
        model = scanner.nextLine();
        myCar.model = model;
        myCar.printInfo();

    }

}

class Car {
    String color;
    String model;

    Car() {
    }

    void start() {
        System.out.println("staring");
    }

    void stop() {
        System.out.println("stopping");
    }

    void printInfo() {
        System.out.println("color = " + color);
        System.out.println("model = " + model);
    }

}