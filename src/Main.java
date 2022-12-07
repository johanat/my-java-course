// exercise vectors o array N.14

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a[] = new int[10], b[] = new int[10], c[] = new int[20];
        boolean growing = true;

        System.out.println("Introduce the first array");

        do {
            for (int i = 0; i < 10; i++) {
                System.out.print((i + 1) + " Introduce a number");
                a[i] = input.nextInt();
            }
            for (int i = 0; i < 9; i++) {
                if (a[i] > i + 1) {
                    growing = true;
                }
                if (a[i] < i + 1) {
                    growing = false;
                    break;
                }
            }
            if (growing == false) {
                System.out.println("The array is disordered");
            }
        } while (growing == false);

        System.out.println("Introduce the second array ");

        do {
            for (int k = 0; k < 10; k++) {
                System.out.print((k + 1) + "Introduce a number ");
                b[k] = input.nextInt();
            }
            for (int j = 0; j < 9; j++) {
                if (b[j] > j + 1) {
                    growing = true;
                }
                if (b[j] < j + 1) {
                    growing = false;
                    break;
                }
            }
            if (growing == false) {
                System.out.println("The number is disordered");
            }

        } while (growing == false);

        int i = 0, j = 0, k = 0;

        while (i < 10 && j < 10) {

            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }

        if (i == 10) {
            while (j < 10) {
                c[k] = b[j];
                k++;
                j++;
            }
        } else {
            while (j == 10) {
                c[k] = a[i];
                k++;
                i++;
            }
        }
        System.out.println("The array finaly is ");
        for (int p = 0; p < 20; p++) {
            System.out.print(c[p] + " -");
        }
    }
}






