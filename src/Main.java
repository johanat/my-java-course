import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        float participation, firstExam, secondExam, examFinal, qualificationFinal;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce the fort note of the student");
        participation = input.nextFloat();
        firstExam = input.nextFloat();
        secondExam = input.nextFloat();
        examFinal = input.nextFloat();

        qualificationFinal= (participation*0.10f)+(firstExam*0.25f)+(secondExam*0.25f)+(examFinal*0.40f);
        System.out.println("QualificationFinal is "+qualificationFinal);

    }
}

