// exercise vectors o array N.13

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numbers[] = new int[10], counterPairs = 0, counterOdds = 0;


        int j = 0, r = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + " Introduce a number ");
            numbers[i] = input.nextInt();
            if (numbers[i] % 2 == 0) {
                counterPairs++;
            } else {
                counterOdds++;
            }
        }

        int[] pairs = new int[counterPairs], odd = new int[counterOdds];

        System.out.println("\nList of the pairs");
        counterPairs = 0;
        counterOdds = 0;

        for (int i = 0; i < 10; i++) {
            if (numbers[i] % 2 == 0) {
                pairs[counterPairs] = numbers[i];
                counterPairs++;
            } else {
                odd[counterOdds] = numbers[i];
                counterOdds++;
            }
        }
        System.out.println("\nThe numbers pairs are:");
        for (int i = 0; i < counterPairs; i++) {
            System.out.print(pairs[i]);
        }
        System.out.println("\nThe numbers odd are:");
        for (int i = 0; i < counterOdds; i++) {
            System.out.print(odd[i]);
        }
    }
}







