// exercise vectors o array N.10

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numbers[];
        int ultimo,index ;
        numbers = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + " Introduce a number ");
            numbers[i] = input.nextInt();
        }
        System.out.println("Enter the number deposition to displace ");
        index=input.nextInt();

       for(int i=0; i<=index; i++){
           ultimo=numbers[9];
           for(int j=8; j>=0; j--){
               numbers[j+1]=numbers[j];
           }
           numbers[0]=ultimo;
       }
        for (int i = 0; i < 10; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}







