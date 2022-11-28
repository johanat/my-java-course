// exercise vectors o array N.2
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner input=new Scanner(System.in);
       float num[]=new float[5];
        for( int i=0; i<5; i++){
            System.out.println(i+1+" Introduce a number");
            num[i]=input.nextFloat();
        }
        System.out.println("Display numbers in reverse  ");
        for(int i=4; i>=0; i-- ){
            System.out.println(num[i]);
        }
    }
}







