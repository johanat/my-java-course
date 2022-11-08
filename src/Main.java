
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Float amount, discount,total;

        Scanner input = new Scanner(System.in);
        System.out.println("Introduce  amount of the buy ");
        amount = input.nextFloat();
        if (amount > 300) {
            discount = amount * 0.20f ;
            total= discount-amount;
        } else {
            total = amount;
        }
        System.out.println("Value to pay of the client is = "+total);
    }
}

