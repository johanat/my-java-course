// exercise vectors o array N.7
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numbers [];
        numbers=new int[10];
        boolean growing= false, decreasing= false; //growing = creciente

        for(int i=0; i<10; i++){
            System.out.print((i+1)+" Introduce a number ");
            numbers[i]=input.nextInt();
        }
        for(int i=0; i<9; i++){
            if(numbers[i]<numbers[i+1]){
                growing=true;
            }
            if(numbers[i]>numbers[i+1]){
                decreasing= true;
            }

        }
        if(growing ==true && decreasing==false){
            System.out.println("\nNumbers is in form growing ");
        }
        else if (growing== false && decreasing==true){
            System.out.println("\nNumbers is in form decreasing ");
        }
        else if(growing==true&& decreasing== true){
            System.out.println("\nNumbers is in form disorder");
        }
        else if(growing==false&& decreasing==false){
            System.out.println("\nNumbers are aqual");
        }
    }
}







