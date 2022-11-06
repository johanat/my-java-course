import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double a, b, c, result1,result2;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce the value of a");
        a=input.nextDouble();
        System.out.println("Introduce the value of b");
        b=input.nextDouble();
        System.out.println("Introduce the value of c");
        c=input.nextDouble();

        result1= (-b+Math.sqrt(Math.pow(b,2)-(4*a*c))) / (2*a);
        result2= (-b-Math.sqrt(Math.pow(b,2)-(4*a*c))) /(2*a);
        System.out.println("\nresultado1= "+result1);
        System.out.println("\nresultado2= "+ result2);
    }
}

