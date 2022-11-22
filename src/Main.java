// exercise bucle N.16

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num, multiplication;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Introduce a number between 0 and 10");
            num = input.nextInt();

        } while (num < 0 || num > 10);

        System.out.println("The table of multiplication is\n");
        for (int i = 0; i < 10; i++) {
            multiplication = num * i;
            System.out.println(num + "*" + i + "=" + multiplication);
        }
    }
}





