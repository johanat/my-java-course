

import java.util.Scanner;
// exercise N.11

public class Main {
    public static void main(String[] args) {
        int num1, num2;
        char operation;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce the num1");
        num1= input.nextInt();
        System.out.println("Introduce the num2");
        num2= input.nextInt();
        System.out.println("Introduce the operation that  want realise");
        operation= input.next().charAt(0);
        if(operation=='s' || operation=='S'){
            System.out.println("The sum is "+(num1+num2));

        }
        else if(operation=='r' || operation=='R'){
            System.out.println("The rest is " +(num1-num2));
        }
        else if(operation=='p' || operation=='P' || operation=='m' || operation=='M'){
            System.out.println("The multiplication  is" +(num1*num2));
        }
        else if (operation== 'd' || operation== 'D'){
            System.out.println("The division is "+(num1/num2));

        }
        else {
            System.out.println("The letter is incorrect");
        }
    }
}

