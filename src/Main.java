

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;
// exercise bucles N.7

public class Main {
    public static void main(String[] args) {

        int num, suma = 0, counter = 1;
        float media = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Introduce a number");
        num = input.nextInt();

        if (num >= 0) {
            suma += num;
        }
        while (num >= 0) {
            System.out.println("Introduce a number");
            num = input.nextInt();
            if (num >= 0) {
                suma += num;
                counter++;
                media = (float)suma / counter;
            }
        }
        System.out.println("La media es " + media);
    }
}



