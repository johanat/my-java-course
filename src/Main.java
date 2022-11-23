// exercise bucle N.20

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int num, totalSalary, salary = 0, maxime=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce a number");
        num = input.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println("Introduce a salary");
            salary = input.nextInt();

            if (salary>maxime) {
                maxime = salary;
            }
        }
        System.out.println("the salary maxime is " +maxime);


    }
}






