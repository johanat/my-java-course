// exercise vectors o array N.4

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num[] = new int[10];
        for(int i=0; i<10; i++){
            System.out.print(i+1+ " Introduce a number ");
            num[i]=input.nextInt();
        }
        System.out.println("The result is");
       for(int i=0; i<5; i++){
           System.out.print(num[i]+ " ");
           System.out.print(num[9-i]+" ");
        }
    }
}







