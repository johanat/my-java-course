

import java.util.Scanner;
// exercise bucles N.1

public class Main {
    public static void main(String[] args) {

        int num, cuadrado=0;

        Scanner input = new Scanner(System.in);
        System.out.println("Introduce a number ");
        num=input.nextInt();

        while(num>=0){
            cuadrado=(int) Math.pow(num,2);
            System.out.println(cuadrado);
            System.out.println("Introduce a number ");
            num=input.nextInt();
        }
    }
}

