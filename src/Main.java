

import java.util.Scanner;
// exercise bucles N.5

public class Main {
    public static void main(String[] args) {

        int num, round, counter=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce a number");
        num = input.nextInt();
        round = (int) (Math.random() * 100);


        do {
            if (round > num) {
                System.out.println("The number is major ");
                System.out.println("Introduce a number");
                num= input.nextInt();
            }
            else {
                System.out.println("The number is minor  ");
                System.out.println("Introduce a number");
                num= input.nextInt();
            }
            counter++;

        } while (num != round);
        System.out.println("Cool you won,you guessed the number in  "+counter+ " try");
        num=input.nextInt();

    }
}


