

import java.util.Scanner;
// exercise N.8

public class Main {
    public static void main(String[] args) {
        int num1;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce a number ");
        num1 = input.nextInt();

        if (num1 < 10) {
            System.out.println("This number has 1 cipher");
        } else if (num1 < 100){
            System.out.println("This number has 2 cipher");
        }
        else if (num1 < 1000){
            System.out.println("This  number has 3 cipher");
        }
        else if(num1 <10000){
            System.out.println("This number has 4 cipher");
        }
        else if(num1 < 100000){
            System.out.println("This number has 5 cipher");
        }
    }
}

