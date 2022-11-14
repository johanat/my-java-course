

import java.util.Scanner;
// exercise N.14

public class Main {
    public static void main(String[] args) {

        int option;
        float measure = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Digit la amount of measure");
        measure = input.nextFloat();
        System.out.println("\nMenu " +
                "\n 1.Hectogramos" +
                "\n 2.Decagramo" +
                "\n 3.Gramo+" +
                "\n 4.Decigramo" +
                "\n 5.Centigramo" +
                "\n 6.Miligramo");
        option = input.nextInt();

        switch (option) {
            case 1:
                measure *= 10;
                System.out.println("The measure in Hectogramos " + measure);
                break;
            case 2:
                measure *= 100;
                System.out.println("The measure in Decagramo" + measure);
                break;
            case 3:
                measure *= 1000;
                System.out.println("The measure in Gramo " + measure);
                break;
            case 4:
                measure *= 10000;
                System.out.println("The measure in Decigramo " + measure);
                break;
            case 5:
                measure *= 100000;
                System.out.println("The measure in Centigramo " + measure);
                break;
            case 6:
                measure *= 1000000;
                System.out.println("The measure in Miligramo " + measure);
                break;
            default:
                System.out.println(" Option incorrect");

        }
    }
}

