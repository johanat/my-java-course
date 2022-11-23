// exercise bucle N.17

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int articleCode, cantidadlitros=0, litros, litersTotal=0, counter=0;
        float  precioLitro, billTotal=0;
        Scanner input = new Scanner(System.in);
        for (int i=0; i<5; i++){
            System.out.println("Introduce code of the bill");
            articleCode=input.nextInt();
            System.out.println("Introduce  sold amount liter ");
            litros=input.nextInt();
            System.out.println("Introduce the price of the liter  ");
            precioLitro= input.nextFloat();
            billTotal+=(float)cantidadlitros*precioLitro;

            if(articleCode==1){
                cantidadlitros+=litros;
            }
            if(cantidadlitros*precioLitro>600){
                counter++;
            }
        }
        System.out.println("billing total is "+ billTotal);
        System.out.println("Amount total in liters of the article sold "+ cantidadlitros);
        System.out.println("How many invoices were issued greater than 600 "+counter);
    }
}






