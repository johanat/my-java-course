

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;
// exercise bucles N.10

public class Main {
    public static void main(String[] args) {


        int num, suma=0;
        Scanner input = new Scanner(System.in);

        for( int i=1; i<=10; i++){
            System.out.println("Introduce a number");
            num= input.nextInt();
            suma+=num;

        }
        System.out.println("The sum = "+suma);

    }
}



