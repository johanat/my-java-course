// exercise bucle N.19

import java.util.Scanner;
// 10 a 5 approved
// 4 conditioned
//0 a 3 suspense

public class Main {
    public static void main(String[] args) {
        int num, counterApproved = 0, counterConditioned = 0, counterSuspense = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {

            do {
                System.out.println("Introduce the notes of the students");
                num = input.nextInt();
            }
            while (num < 0 || num >10);
            if (num == 4) {
                counterConditioned++;
            } else if (num >= 5) {
                counterApproved++;
            } else {
                counterSuspense++;
            }
        }
        System.out.println("Total of the students approved = " + counterApproved + "\nTotal of the students conditioned = " + counterConditioned + "\nTotal of the students Suspense = " + counterSuspense);
    }
}






