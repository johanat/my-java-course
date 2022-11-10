

import java.util.Scanner;
// exercise N.9

public class Main {
    public static void main(String[] args) {
        int day, month, year;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce the day");
        day = input.nextInt();
        System.out.println("Introduce the month ");
        month = input.nextInt();
        System.out.println("Introduce the first number ");
        year = input.nextInt();
        if (day >= 1 && day <= 30) { // si el dia es correct
            if (month >= 1 && month <= 12) { // si el mes es correct
                if (year != 0) { // si el año es correct
                    System.out.println("The data is correct");
                }else{
                    System.out.println("The year is incorrect");
                }
            }else{
                System.out.println("The month is incorrect");
            }
        }else{
            System.out.println("The day is correct");
        }
    }
}

