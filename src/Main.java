
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char letter;
        Scanner input = new Scanner (System.in);
        System.out.println("Introduce a letter");
        letter= input.nextLine().charAt(0); // in java not manage nextChar for read must us put NestLine.charAt(0) not read chars

        if(Character.isUpperCase(letter)){
            System.out.println("Yes is capital letter ");
        }
        else {
            System.out.println("Not is  capital letter ");
        }
    }
}

