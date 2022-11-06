import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int hoursTotal, weeks, days, hours;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce the Number of horas total ");
        hoursTotal = input.nextInt();
        weeks = hoursTotal / 168;
        days = hoursTotal % 168 / 24;
        hours = hoursTotal % 168 % 24;
        System.out.println("\nsemanas= " + weeks + "\ndias= " + days + "\nhoras= " + hours);
    }
}

