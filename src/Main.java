// exercise vectors o array N.5
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a[] , b[], c[];
        a=new int[10];
        b=new int [10];
        c=new int[20];

        System.out.println("Fill the table A");
        for(int i=0; i<10; i++){
            System.out.print((i+1)+" Introduce a number ");
            a[i]=input.nextInt();
        }
        System.out.println("\n Fill the table B");

        for(int k=0; k<10; k++){
            System.out.print((k+1)+" Introduce a number ");
            b[k]=input.nextInt();
        }
        int j=0;
        for(int i=0; i<10; i++ ){
            c[j]=a[i];
            j++;
            c[j]=b[i];
            j++;
        }
        j=0;
        System.out.println("Result of the table C is");
        for( int i=0; i<20; i++){
            System.out.print(c[i]+" ");
        }
    }
}







