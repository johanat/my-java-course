

import java.util.Scanner;
// exercise bucles N.4

public class Main {
    public static void main(String[] args) {

        int num,i ;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce a number ");
        num = input.nextInt();
       for( i=0; num>=0; i++){
           System.out.println("Introduce a number ");
           num = input.nextInt();
       }
        System.out.println("Number introduced are "+i + " Not negative");
    }
}

