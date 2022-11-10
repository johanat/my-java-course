

import java.util.Scanner;
// exercise N.10

public class Main {
    public static void main(String[] args) {
        int day, month, year;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce the day");
        day = input.nextInt();
        System.out.println("Introduce the month ");
        month = input.nextInt();
        System.out.println("Introduce the year ");
        year = input.nextInt();

        if(day>=1 && day<=31 && month==1 && year !=0) {
            System.out.println("The date is correct");

        }
        else if(day>=1 && day<=28 && month==2 && year !=0){
            System.out.println("The date is correct");

        }
        else if (day>=1 && day<=31 && month ==3 && year !=0) {
            System.out.println("The date is correct");

        }
        else if( day>=1 && day<=30 && month ==4 && year !=0){
            System.out.println("The date is correct");

        }
        else if (day>=1 && day<=31 && month ==5 && year !=0){
            System.out.println("The date is correct");

        }
        else if (day>=1 && day<=30 && month ==6 && year !=0){
            System.out.println("The date is correct");

        }
        else if(day>=1 && day<=31 && month == 7 && year !=0){
            System.out.println("The date is correct");

        }
        else if(day>=1 && day<=31 && month == 8 && year !=0){
            System.out.println("The date is correct");

        }
        else if(day>=1 && day<=30 && month == 9 && year !=0){
            System.out.println("The date is correct");

        }
        else if (day>=1 && day<=31 && month == 10 && year !=0){
            System.out.println("The date is correct");

        }
        else if ( day>=1 && day<=30 && month == 11 && year !=0){
            System.out.println("The date is correct");

        }
        else if ( day>=1 && day <= 31 && month == 12 && year !=0){
            System.out.println("The date is correct");

        }
        else {
            System.out.println("The date is incorrect");
        }
    }
}

