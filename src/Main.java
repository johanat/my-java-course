import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int salary= 1000;
        int commission;
        float valueFromCar, totalMonthly;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce  the number of cars sold");
        commission = input.nextInt();
        System.out.println("Introduce the amount of the cars ");
       valueFromCar = input.nextFloat();
        totalMonthly= salary+(commission*150)+(0.05f*valueFromCar*commission);
        System.out.println("The salary the an employee is "+totalMonthly);

    }
}

