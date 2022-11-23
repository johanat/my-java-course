// exercise bucle N.18

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int code, cantidadlitros = 0, counter = 0;
        float precioLitro = 0, billTotal = 0;
        double litros;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            do {
                System.out.println("Introduce code of the bill");
                code = input.nextInt();
            } while (code < 1 || code > 3);
            System.out.println("Introduce  sold amount liter ");
            litros = input.nextFloat();
            switch (code) {
                case 1:
                    precioLitro = 0.6f;
                    break;
                case 2:
                    precioLitro = 3f;
                    break;
                case 3:
                    precioLitro = 1.25f;
                    break;
            }

            if (code == 1) {
                cantidadlitros += litros;
            }
            billTotal += (float) litros * precioLitro;
            if (litros * precioLitro > 600) {
                counter++;
            }
        }
        System.out.println("billing total is " + billTotal);
        System.out.println("Amount total in liters of the article sold 1:" + cantidadlitros);
        System.out.println("How many invoices were issued greater than 600 " + counter);
    }
}






