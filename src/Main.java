// exercise bucle N.13

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num, sumaNumberPositive = 0, sumaNumberNegative = 0, counterP = 0, counterN = 0, counterZero = 0;
        float mediaP = 0, mediaN = 0;


        Scanner input = new Scanner(System.in);
        
        for (int i = 1; i <= 10; i++) {
            System.out.println("Introduce a number " + i);
            num = input.nextInt();

            if (num == 0) {
                counterZero++;
            } else if (num > 0) {
                sumaNumberPositive += num;
                counterP++;
            } else {
                sumaNumberNegative += num;
                counterN++;
            }
        }
        if (counterP == 0) {
            System.out.println(" Can't  remove media, there is negative numbers ");
        } else {
            mediaP = (float) sumaNumberPositive / counterP;
            System.out.println("The media of the numbers positive is " + mediaP);
        }
        if (counterN == 0) {
            System.out.println("Can't remove media, There is negative numbers ");
        } else {
            mediaN = (float) sumaNumberNegative / counterN;
            System.out.println("The media of the numbers positive is " + mediaN);
        }
        System.out.println("The amount of is " + counterZero);
    }
}




