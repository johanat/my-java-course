

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;
// exercise bucles N.8

public class Main {
    public static void main(String[] args) {

      Scanner input =  new Scanner(System.in);
        int num;
        System.out.println("Introduce a number ");
        num= input.nextInt();

       for ( int i=1; i<=num; i++){
           System.out.println(i);
       }
    }
}



