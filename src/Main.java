// exercise vectors o array N.10

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numbers[];
        int num, index=0;
        numbers = new int[10];
        boolean creciente = false;
        
        do {
            for (int i = 0; i < 5; i++) {
                System.out.print((i + 1) + " Introduce a number ");
                numbers[i] = input.nextInt();
            }
            for (int i = 0; i < 4; i++) {
                if (numbers[i] < numbers[i + 1]) {
                    creciente = true;
                }
                if (numbers[i] > numbers[i + 1]) {
                    break;
                }
            }
            if (creciente = false) {
                System.out.println("The number are disordered");
            }
        } while (creciente = false);

        System.out.println("Introduce a number ");
        num = input.nextInt();

        for(int i=0; numbers[i]<num && num<5; i++){
            index++;
        }
        for(int i=4; i>=index; i--){
            numbers[i+1]=numbers[i];
        }
        numbers[index]=num;
        System.out.println("the arrangement is as follows ");
        for(int i=0; i<6; i++){
            System.out.print(numbers[i]+" ");
        }
    }
}







