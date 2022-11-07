import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num1, num2;

        Scanner input = new Scanner(System.in);
        System.out.println("Introduce a num1");
        num1=input.nextInt();
        System.out.println("Introduce a num2");
        num2=input.nextInt();
        if(num1>num2){
            System.out.println("the largest number is = "+num1);
        }
        else if(num2>num1){
            System.out.println("The largest number is = "+ num2);
        }
        else{
            System.out.println("Are same");
        }
    }
}

