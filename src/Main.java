import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            //Create file
            File myObj = new File("filename.txt");
            if (myObj.createNewFile() == true) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            //Write to file
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("This is a test!");
            myWriter.append("\nEsto es un añaadido");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

            //Read file
            String text = "";
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine() == true) {
                String line = myReader.nextLine();
                text += line;
            }

            System.out.println("The text is = " + text);
            myReader.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

class Person {

    String name;
    int age;
    float weight = 90; //Peso

    Person(String paraName, int paramAge){
        this.name = paraName;
        this.age = paramAge;
    }

    void eat() {
        System.out.println("Eating...");
    }

    void sleep() {
        System.out.println("Sleeping...");
    }

    void printInfo() {
        System.out.println("My name is " + name + ", I'm "+ age + ", and my weight is " + weight);
    }
}