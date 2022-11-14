

import java.util.Scanner;
// exercise N.12

public class Main {
    public static void main(String[] args) {
        int note;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce a note");
        note = input.nextInt();
        switch (note){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("The note is insufficient ");
                break;
            case 5:
            case 6:
                System.out.println("The note is enough");
                break;
            case 7:
            case 8:
                System.out.println("The note is well remarkable");
                break;
            case 9:
            case 10:
                System.out.println("The note is well outstanding");
                break;
            default:System.out.println("The note is incorrect");
        }
    }
}

