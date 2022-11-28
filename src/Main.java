// exercise vectors o array N.1
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner input=new Scanner(System.in);
       float num[]=new float[5];
        for( int i=0; i<5; i++){
            System.out.println(i+1+" Introduce a number");
            num[i]=input.nextFloat();
        }
        for(float i:num){
            System.out.println(i);
        }
    }
}







