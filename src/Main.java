import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        float guillermo, luis, juan, total;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce the quantity of money that has Guillermo ");
        guillermo= input.nextFloat();
        luis= guillermo/2;
        juan= (guillermo+luis)/2;
        total=guillermo+luis+juan;
        System.out.println("\nGuillermo: "+guillermo+"\n luis: "+luis+"\njuan. "+juan+ "\n\n la cantidad de dinero tiene juan es : "+total);
    }
}

