// exercise vectors o array N.8

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numbers[], num, index;
        numbers = new int[10];
        for (int i = 0; i < 8; i++) {
            System.out.print(" Introduce a number ");
            numbers[i] = input.nextInt();
        }
        System.out.println("N.8 Introduce a number ");
        num = input.nextInt();
        System.out.println("Introduce a position");
        index = input.nextInt();

        for (int i = 7; i >= index; i--) {
            numbers[i + 1] = numbers[i];
            if (i == index) {
                numbers[index] = num;
            }
        }
        numbers[index] = num;
        for (int i = 0; i < 9; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}







