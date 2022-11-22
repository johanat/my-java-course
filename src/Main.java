// exercise bucle N.15

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int  ages, counterAges =0,counterHeights=0, sumaOfAges=0;
        float sumaOfHeights=0,mediaAges=0, mediaHeights=0, heights;
        Scanner input = new Scanner(System.in);
        for(int i=0; i<5; i++){
            System.out.println("Introduce the age of the student ");
            ages=input.nextInt();
            sumaOfAges+=ages;
            mediaAges=(float) sumaOfAges/5;
            if(ages>18){
                counterAges++;
            }
        }
        System.out.println("The media of ages is "+ mediaAges);
        System.out.println("Total number of students over 18 years is "+counterAges );

        for(int j=0; j<5; j++){
            System.out.println("Introduce the heights of the students");
            heights=input.nextFloat();
            sumaOfHeights+=heights;
            mediaHeights= (float) Math.round(100*sumaOfHeights/5)/100;

            if(heights>1.75){
                counterHeights++;
            }
        }
        System.out.println("the media of heights is "+ mediaHeights);
        System.out.println("Total numbers of students who measure more than  "+counterHeights );


    }
}




