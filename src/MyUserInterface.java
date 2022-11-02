import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyUserInterface extends JFrame {

    private JPanel mainPanel;
    private JButton addUserButton;
    private JLabel print;
    public JButton Save;
    private JButton delete;
    public JTextField deleteAndUpDate;
    private JButton updateButton;
    static ArrayList<Persona> peopleUser = new ArrayList<>(); // (variable global) lo ven todos y (variables locales)  must be inside a method and  Only the attributes of said method will be handled. Example MyUserInterface is one more method if you want only this method to see this array you must put it inside.
    public static JLabel print2;

    MyUserInterface() {
        print2 = print;
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(new Dimension(670, 600));

        addUserButton.addActionListener(e -> {
            ButtonOfCall viewPanel = new ButtonOfCall(deleteAndUpDate, false); // before the call to other class must  instantiate an object.
            viewPanel.setVisible(true); // used to call another window or example class ButtonOfCall
        });
        Save.addActionListener(e -> {
            try {
                FileWriter fw = new FileWriter("C:\\Users\\Darwin\\IdeaProjects\\my-java-course\\saveArrays");
                //  String dataUser = fromArrayToString(peopleUser);
                String dataUser = fromArrayToString(peopleUser);

                fw.write(dataUser);
                fw.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        delete.addActionListener(e -> {
            String dataDelete = deleteAndUpDate.getText();
            for (int i = 0; i < peopleUser.size(); i++) {
                if (peopleUser.get(i).id == Long.parseLong(dataDelete)) {
                    //noinspection SuspiciousListRemoveInLoop
                    peopleUser.remove(i);
                    printfArray();
                }
            }
        });
        updateButton.addActionListener(e -> {

            ButtonOfCall viewPanel = new ButtonOfCall(deleteAndUpDate, true);
            viewPanel.setVisible(true);
        });
    }

    static void printfArray() {
        String printfVariable = "";

        for (Persona persona : peopleUser) {

            //noinspection StringConcatenationInLoop
            printfVariable += persona.toString();
        }
        print2.setText(printfVariable);
    }

    public static void main(String[] args) {

        JFrame frame = new MyUserInterface();
        frame.setVisible(true);

        String data = "";
        try {
            File file = new File("saveArrays");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                //noinspection StringConcatenationInLoop
                data += myReader.nextLine();
            }
            peopleUser = fromStringToArray(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        printfArray();
    }
    String fromArrayToString(ArrayList<Persona> personas) {
        String general = "";

        int counter = personas.size() - 1;

        for (int i = 0; i < personas.size(); i++) {
            String nameC = personas.get(i).name;
            String ageC = String.valueOf(personas.get(i).age);
            String weightC = Float.toString(personas.get(i).weight);
            boolean authorization = personas.get(i).authorizationBoolean;
            long millis = personas.get(i).id;

            //noinspection StringConcatenationInLoop
            general += (nameC + "&" + ageC + "&" + weightC + "&" + authorization + "&" + millis);
            if (i < counter) {
                general += "##";
            }
        }
        fromStringToArray(general);
        return general;
    }

    static ArrayList<Persona> fromStringToArray(String general) {

        ArrayList<Persona>nameUser = new ArrayList<>();
        String[] finals;

        String[] parts = general.split("##");

        for (String parte : parts) {
            finals = parte.split("&");
            Persona user = new Persona(finals[0], Integer.parseInt(finals[1]), Float.parseFloat(finals[2]), Boolean.getBoolean(finals[3]), Long.parseLong(finals[4]));
            nameUser.add(user);
        }

        return nameUser;
    }

    static long getId() {

        long idMax = 0;


        for (Persona persona : peopleUser) {
            if (persona.id > idMax) {
                idMax = persona.id;
            }
        }
        return idMax + 1;
    }
}


class Persona {
    String name;
    int age;
    float weight;
    boolean authorizationBoolean;
    long id;

    Persona(String name, int age, float weight, boolean authorization1, long id) {

        this.name = name;
        this.age = age;
        this.weight = weight;
        this.authorizationBoolean = authorization1;
        this.id = id;

    }

    public String toString() {


        return "<html> "+"Id: "+id+ "<br/>"+"Name: " + name + "<br/>" + " Age: " + age + "<br/>" + " Weight: " + weight + "<br/>" + " Authorized: " + authorizationBoolean + "<br/> " + "__________________________" + "<br/>";
    }
}



