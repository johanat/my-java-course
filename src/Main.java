// exercise bucle N.14

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float salary, sumSalary = 0;
        int counter = 0;


        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            System.out.println("Introduce the salary " + i);
            salary = input.nextFloat();
            sumSalary += salary;
            if (salary > 1000) {
                counter++;
            }
        }
        System.out.println("The sum of all the salary is " + sumSalary);
        System.out.println(" total major to 1000 = " + counter);
    }
}




