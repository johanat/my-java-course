import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int  number;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce a number");
        number= input.nextInt();
        if( number%10==0){
            System.out.println("Yes is multiple of 10  = "+number);
        }
        else{
            System.out.println("Not is multiple of 10");
        }
    }
}

