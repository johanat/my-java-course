

import java.util.Scanner;
// exercise bucles N.6

public class Main {
    public static void main(String[] args) {

        int num, suma;
        Scanner input= new Scanner(System.in);
        System.out.println("Introduce a number");
        num= input.nextInt();
        suma=num;
        while(num!=0){
            System.out.println("introduce a number");
            num= input.nextInt();
            suma+=num;
        }
        System.out.println("sum of all the number are : "+ suma);
    }
}


