// exercise vectors o array N.3

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float num[] = new float[5];

        float mediaP = 0, mediaN = 0, counter = 0, sumaP = 0, sumaN = 0, counterP = 0, counterN = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println(i + 1 + " Introduce a number");
            num[i] = input.nextFloat();
        }
        for (float i : num) {

            if (i > 0) {
                counterP++;
                sumaP += i;
                mediaP = sumaP / counterP;
            } else if (i == 0) {
                counter++;
            } else if (i < 0) {
                counterN++;
                sumaN += i;
                mediaN = sumaN / counterN;
            }
        }
        System.out.println("Media of number positive is " + mediaP);
        System.out.println("Media of number negative is " + mediaN);
        System.out.println("This is the amount of zeros " + counter);

    }
}







