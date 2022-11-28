// exercise bucle N.22


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int note, counter = 0;
        boolean thereIsNotes = false;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            do {
                System.out.println("Introduce a note");
                note = input.nextInt();
            }
            while (note > 10 || note < 0);
            if (note < 5) {
                thereIsNotes = true;
            }
        }
        if (thereIsNotes == true) {
            System.out.println("There are suspense");
        } else {
            System.out.println("there is no suspense ");
        }
    }
}







