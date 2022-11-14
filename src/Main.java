

import java.util.Scanner;
// exercise N.13

public class Main {
    public static void main(String[] args) {
        final int amount = 1000;
        int option;
        float inputMoney, exitMoney;
        Scanner input = new Scanner(System.in);
        System.out.println("\nwelcome to your ATM \n1.deposit money into the account\n" +
                "2.withdraw money to the account\n" +
                "3.exit ");
        option = input.nextInt();
        switch (option) {
            case 1:
                System.out.println("Write the amount ");
                inputMoney = input.nextFloat();
                System.out.println("the total of your account is " + (amount + inputMoney));
                break;
            case 2:

                System.out.println("Write the amount");
                exitMoney = input.nextFloat();
                if (exitMoney > amount) {
                    System.out.println("Your Amount is  insufficient");
                } else {
                    System.out.println("the total of your account is " + (amount - exitMoney));
                }
                break;
            case 3:
            default:
                System.out.println("wrong menu option");
                break;
        }
    }
}

