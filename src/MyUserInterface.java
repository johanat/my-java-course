import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyUserInterface extends JFrame {

    private JPanel mainPanel;
    private JTextField name1;
    private JTextField edad;
    private JTextField peso;
    private JRadioButton buttonAutorizacion;
    private JButton addUserButton;
    private JPanel tituloGeneral;
    private JLabel print;
    private JButton Save;
    private JButton delete;
    private JTextField deletePerson;
    private JButton Delete;
    static ArrayList<Persona> peopleUsuare = new ArrayList<>(); // (variable global) lo ven todos y (variables locales)  debe estar dentro de un metodo y sera manejados solo los atributos de dicho metodo  ejemplo  MyUserInterface es un metodo mas si quieres que solo este metodo vea este array debes ponerlo dentro.

    private static JLabel print2;

    MyUserInterface() {
        print2 = print;
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(new Dimension(500, 600));

        addUserButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String nameUsure = name1.getText();
                String age = edad.getText();
                String weight = peso.getText();
                boolean autorizacionR = buttonAutorizacion.isSelected();

                Persona person = new Persona(name1.getText(), Integer.parseInt(age), Float.parseFloat(weight), buttonAutorizacion.isSelected());
                peopleUsuare.add(person);

                String general = "";

                for (int i = 0; i < peopleUsuare.size(); i++) {
                    String nameC = peopleUsuare.get(i).name;
                    String ageC = String.valueOf(peopleUsuare.get(i).age);
                    String weightC = Float.toString(peopleUsuare.get(i).weight);
                    boolean autorizacionC = peopleUsuare.get(i).autorizacion;

                    general += "<html> Name: " + nameC + "<br/>" +
                            " Age: " + ageC + "<br/>" +
                            " Weight: " + weightC + "<br/>" +
                            " Autorized: " + autorizacionC + "<br/> " +
                            "________________" + "<br/>";
                    print.setText(general);
                }
                name1.setText("");
                edad.setText("");
                peso.setText("");
            }

        });
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fw = new FileWriter("C:\\Users\\Darwin\\IdeaProjects\\my-java-course\\saveArrays");
                    String dataUser = fromArrayToString(peopleUsuare);

                    fw.write(dataUser);
                    fw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String datoDelete = deletePerson.getText();

                for (int i = 0; i < peopleUsuare.size(); i++) {
                    if (peopleUsuare.get(i).name.startsWith(datoDelete) == true) {
                        peopleUsuare.remove(i);
                        printfArray();
                    }
                }
            }
        });
    };
     static void printfArray (){
         String imprimir = "";

         for (int i = 0; i < peopleUsuare.size(); i++) {

             imprimir = imprimir + peopleUsuare.get(i).toString();
         }
         print2.setText(imprimir);

    }


    public static void main(String[] args) {

        JFrame frame = new MyUserInterface();
        frame.setVisible(true);

        String data = "";
        try {
            File file = new File("saveArrays");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();
            }
            peopleUsuare = fromStringToArray(data);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        printfArray();

    }

    static String fromArrayToString(ArrayList<Persona> personas) {
        String general = "";

        int counter = personas.size() - 1;

        for (int i = 0; i < personas.size(); i++) {
            String nameC = personas.get(i).name;
            String ageC = String.valueOf(personas.get(i).age);
            String weightC = Float.toString(personas.get(i).weight);
            boolean autorizacionC = personas.get(i).autorizacion;

            general += nameC + "&" + ageC + "&" + weightC + "&" + autorizacionC;
            if (i < counter) {
                general += "##";
            }
        }
        fromStringToArray(general);

        return general;

    }


    static ArrayList<Persona> fromStringToArray(String general) {

        ArrayList nameUser = new ArrayList<>();
        String[] finals;

        String[] partes = general.split("##");

        for (int i = 0; i < partes.length; i++) {
            finals = partes[i].split("&");
            Persona user = new Persona(finals[0], Integer.parseInt(finals[1]), Float.parseFloat(finals[2]), Boolean.getBoolean(finals[3]));
            nameUser.add(user);
        }
        return nameUser;
    }
}

class Persona {
    String name;
    int age;
    float weight;
    boolean autorizacion;

    Persona(String name, int age, float weight, boolean autorizacion) {

        this.name = name;
        this.age = age;
        this.weight = weight;
        this.autorizacion = autorizacion;

    }

    public String toString() {
        //return "Name:" + name+" Edad:"+age+" Peso:"+weight+" Autorizacion:"+autorizacion;

        return "<html> Name: " + name + "<br/>" +
                " Age: " + age + "<br/>" +
                " Weight: " + weight + "<br/>" +
                " Autorized: " + autorizacion + "<br/> " +
                "________________" + "<br/>";
    }
}



