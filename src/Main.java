// exercise vectors o array N.12

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numbers[];
        int num, index = 0;
        numbers = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + " Introduce a number ");
            numbers[i] = input.nextInt();
        }
        do {
            System.out.println("Introduce an index from 0 to 9");
            index = input.nextInt();

        } while (index < 0 || index > 9);

        for (int i = index; i < 9; i++) {
            numbers[i] = numbers[i + 1];
        }
        System.out.println("The numbers array is \n");
        for (int i = 0; i < 9; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println("the arrangement is as follows ");
        for (int i = 0; i < 6; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}







