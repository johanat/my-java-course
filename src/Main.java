// exercise vectors o array N.16

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int suma1 = 0, suma2 = 0, suma3 = 0, num;
        float first[] = new float[5], second[] = new float[5], third[] = new float[5], sumaStudent = 0, mediaStudent = 0, media1 = 0, media2 = 0, media3 = 0;
        boolean major10 = false;

        System.out.println(" \nNote date of the first trimester");
        for (int i = 0; i < 5; i++) {
            System.out.print("Note of the " + (i + 1) + " student ");
            first[i] = input.nextInt();
            suma1 += first[i];

        }

        media1 = suma1 / 5f;

        System.out.println("\n Note date of the second trimester");
        for (int i = 0;
             i < 5; i++) {
            System.out.print("Note of the " + (i + 1) + " student ");
            second[i] = input.nextInt();
            suma2 += second[i];
        }

        media2 = suma2 / 5f;

        System.out.println("\nNote date of the third trimester");
        for (
                int i = 0;
                i < 5; i++) {
            System.out.print("Note of the " + (i + 1) + " student ");
            third[i] = input.nextInt();
            suma3 += third[i];
        }
        media3 = suma3 / 5f;

        System.out.println("\nMedia of the first trimester= " + media1);
        System.out.println("Media of the second trimester = " + media2);
        System.out.println("Media of the third trimester = " + media3);

        System.out.println("\n Introduce the position ");
        num = input.nextInt();

        if (num > 5) {
            System.out.println("Try agan");
        }

        sumaStudent += first[num] + second[num] + third[num];
        
        mediaStudent = sumaStudent / 3f;

        System.out.println("Media of the position student is  " + mediaStudent);
    }
}






