// exercise vectors o array N.15

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num[] = new int[10];
        boolean crecient = true;
        int number;
        boolean numberFound=false;

        for (int i = 0; i < 10; i++) {
            System.out.print((i ) + ". Introduce a number");
            num[i] = input.nextInt();
        }
        for (int i = 0; i < 9; i++) {
            if (num[i] < num[i + 1]) {
                crecient = true;
            } else {
                crecient = false;
                break;
            }
        }

        if (crecient == false) {
            for (int k = 0; k < 10; k++) {
                System.out.println("\n Please try again");
                System.out.print((k + 1) + ". Introduce a number");
                num[k] = input.nextInt();
            }
        }
        System.out.println("Introduce a number");
        number = input.nextInt();

        for (int i = 0; i < 10; i++) {
            if(num[i]==number){
                numberFound=true;
                System.out.println("The position is "+ i );
                break;
            }
            else{
                numberFound=false;
            }
        }
        if(numberFound==false){
            System.out.println("The position not is found");
        }

    }
}






