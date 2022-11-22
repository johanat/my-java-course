
// exercise bucle N.12

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        long factorial=1;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce a number ");
        num= input.nextInt();
        for( int i=1; i<=num;  i++  ){
            factorial*=i;
        }
        System.out.println("The factorial of "+ num + " is "+factorial );

        }
    }




