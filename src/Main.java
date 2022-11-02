import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        float note1,note2, note3, sum=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite 3 notas");
        note1=input.nextFloat();
        note2= input.nextFloat();
        note3= input.nextFloat();

        sum=note1+note2+note3;
        System.out.print(sum);




    }
}

