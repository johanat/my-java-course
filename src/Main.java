import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        ArrayList<String> wordsArray = new ArrayList<>(); // instanciando o creando un array
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce 10 words ");
        for (int i = 0; i < 10; i++) {
            String words = scanner.next();
            wordsArray.add(words);
        }
        System.out.println(" 1. Print the words that starts with a given \n 2. Check if a word be in the array");
        Scanner scanner1 = new Scanner(System.in);
        int numberUser = scanner1.nextInt();
        boolean same = false;
        String wordCompared = null;
        if (numberUser == 1) {
            System.out.println("Introduce a word");
            String wordPrefix = scanner1.next();
            for (int j = 0; j < wordsArray.size(); j++) {
                if (wordsArray.get(j).startsWith(wordPrefix)) {
                    System.out.println(wordsArray.get(j));
                }
            }
        }
        if (numberUser == 2) {
            System.out.println("Introduce a word");
            String wordCompare = scanner1.next();
            for (int k = 0; k < wordsArray.size(); k++) {
                if (wordsArray.get(k).equals(wordCompare)) {
                    wordCompared = wordsArray.get(k);
                    same = true;
                }
            }
            if (same) {
                System.out.println("Yes, the word exists  " + "(" + wordCompared + ") ^_^");
            } else {
                System.out.println("No, the word  doesn't exist -_-");
            }
        }
    }

}



