
import java.util.Scanner;
// exercise N.7

public class Main {
    public static void main(String[] args) {
        int num1, num2, num3, result;
        Scanner input= new Scanner(System.in);
        System.out.println("Introduce the first number ");
        num1= input.nextInt();
        System.out.println("Introduce the second number ");
        num2=input.nextInt();
        System.out.println("Introduce the third number");
        num3= input.nextInt();
        if(num1>num2 && num2>num3){
            System.out.println("Number ordered from greatest to least "+num1+"-"+num2+"-"+num3);
        }
        else if ( num1>num3 && num3>num2){
            System.out.println("Number ordered from greatest to least "+num1+"-"+num3+"-"+num2);
        }
        else if(num2>num1 && num1>num3){
            System.out.println("Number ordered from greatest to least "+num2+"-"+num1+"-"+num3);
        }
        else if (num2>num3 && num3>num1){
            System.out.println("Number ordered from greatest to least "+num2+"-"+num3+"-"+num1);
        }
        else if (num3>num1 && num1>num2){
            System.out.println("Number ordered from greatest to least "+num3+"-"+num1+"-"+num2);
        }
        else {
            System.out.println("Number ordered from greatest to least "+num3+"-"+num2+"-"+num1);
        }
    }
}

