

import java.util.Scanner;
// exercise bucles N.3

public class Main {
    public static void main(String[] args) {

        int num;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce a number ");
        num = input.nextInt();

        while(num!=0){
            if(num%2==0){
                System.out.println("The number "+num+ " is pare ");
            }
            else{
                System.out.println("The number "+ num+ " is odd");
            }
            System.out.println("Introduce a number ");
            num=input.nextInt();
        }
    }
}

