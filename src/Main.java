

import java.util.Scanner;
// exercise bucles N.2

public class Main {
    public static void main(String[] args) {

        int num, result;

        Scanner input = new Scanner(System.in);
        System.out.println("Introduce a number ");
        num=input.nextInt();

        while(num!=0){
            if(num>0){
                System.out.println("The number is positive (+)");
            }
            else{
                System.out.println("The number is negative (-)");
            }
            System.out.println("Introduce a number ");
            num=input.nextInt();
        }
    }
}

