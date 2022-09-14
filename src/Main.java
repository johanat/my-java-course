import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int num1;
        int num2;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce the first number");
        num1 = scanner.nextInt();
        System.out.println("Introduce the second number");
        num2 = scanner.nextInt();
        Calculator operation = new Calculator();

        System.out.println("suma "+operation.sum(num1,num2));
        System.out.println("resta "+operation.subtract(num1,num2));
        System.out.println("multiplicacion "+operation.multiply(num1,num2));
        System.out.println("division "+operation.divide(num1,num2));

    }
}


class Calculator {

    Calculator() {

    }

    int sum(int num1, int num2) {
        int sumR;
        sumR = (num1+num2);

        return sumR;
    }

    int subtract(int num1, int num2) {
        int subtractR;
        subtractR = num1-num2;
        return subtractR;
    }

    int multiply(int num1, int num2) {
        int multiplyR;
        multiplyR = num1*num2;
        return multiplyR;
    }

    double divide(int num1, int num2) {
        double divieR;
        divieR =num1*1f / num2;
        return divieR;
    }
}


