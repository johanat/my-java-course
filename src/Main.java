// exercise vectors o array N.9

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numbers[];
        int ultimo;
        numbers = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + " Introduce a number ");
            numbers[i] = input.nextInt();
        }
        ultimo = numbers[9];

        for (int i = 8; i >= 0; i--) {
            numbers[i + 1] = numbers[i];
        }
        numbers[0] = ultimo;

        for (int i = 0; i < 10; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}







