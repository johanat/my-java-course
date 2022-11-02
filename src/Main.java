import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       Scanner input = new Scanner(System.in);
       float hoursWeekly, hoursEveryday, salaryWeekly;
        System.out.println("Introduce your working  hours weekly and the hour of work ");
        hoursWeekly= input.nextFloat();
        hoursEveryday = input.nextFloat();
        salaryWeekly= hoursWeekly*hoursEveryday;
        System.out.println("The salary weekly = "+salaryWeekly);
        
    }
}

