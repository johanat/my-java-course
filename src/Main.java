// exercise bucle N.21


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num;
        boolean thereIsNegative= false;

        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce a number");
            num=input.nextInt();
            if(num<0){
                thereIsNegative=true;
            }
        }
            if(thereIsNegative==true){
                System.out.println("exist  negative numbers ");
            }
            else{
                System.out.println("it doesn't negative numbers");
            }
        }
    }







