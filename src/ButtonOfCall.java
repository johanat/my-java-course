import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ButtonOfCall extends JFrame {

    private JPanel panel1;
    @SuppressWarnings("unused")
    private JPanel MainTitle;
    public JTextField name1;
    public JTextField age1;
    public JTextField peso;
    @SuppressWarnings("unused")
    private JRadioButton buttonAuthorization;
    public JButton acceptButton;
    private JButton cancelButton;
    boolean update1;


    public static void main(String[] args) {


        String data = "";
        try {
            File file = new File("saveArrays");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                //noinspection StringConcatenationInLoop
                data += myReader.nextLine();
            }
            MyUserInterface.peopleUser = fromStringToArray(data);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        printfArray();


    }

    ButtonOfCall(JTextField inputText, boolean update) {

        this.update1 = update;

        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.setSize(new Dimension(670, 600));

        acceptButton.addActionListener(e -> {
            if (!update1) {
                String age = age1.getText();
                String weight = peso.getText();
                buttonAuthorization.isSelected();
                long millis = MyUserInterface.getId();

                Persona person = new Persona(name1.getText(), Integer.parseInt(age), Float.parseFloat(weight), buttonAuthorization.isSelected(), millis);
                MyUserInterface.peopleUser.add(person);

                name1.setText("");
                age1.setText("");
                peso.setText("");
                printfArray();

            }
            String idToUpdate = inputText.getText();

            if (update) {
                for (int i = 0; i < MyUserInterface.peopleUser.size(); i++) {
                    if (MyUserInterface.peopleUser.get(i).id == Long.parseLong(idToUpdate)) {
                        if (!name1.getText().equals("")) {
                            MyUserInterface.peopleUser.get(i).name = name1.getText();
                        }
                        if (!age1.getText().equals("")) {
                            MyUserInterface.peopleUser.get(i).age = Integer.parseInt(age1.getText());
                        }
                        if (!peso.getText().equals("")) {
                            MyUserInterface.peopleUser.get(i).weight = Float.parseFloat(peso.getText());
                        }
                        MyUserInterface.peopleUser.get(i).authorizationBoolean = buttonAuthorization.isSelected();
                    }
                }
                printfArray();
                name1.setText("");
                age1.setText("");
                peso.setText("");
            }


        });
        cancelButton.addActionListener(e -> setVisible(false));
    }

    static void printfArray() {
        StringBuilder printf = new StringBuilder();

        for (int i = 0; i < MyUserInterface.peopleUser.size(); i++) {

            printf.append(MyUserInterface.peopleUser.get(i).toString());
        }
        MyUserInterface.print2.setText(printf.toString());
    }


    static ArrayList<Persona> fromStringToArray(String general) {

        ArrayList<Persona> nameUser = new ArrayList<>();
        String[] finals;

        String[] parts = general.split("##");

        for (String parte : parts) {
            finals = parte.split("&");
            Persona user = new Persona(finals[0], Integer.parseInt(finals[1]), Float.parseFloat(finals[2]), Boolean.getBoolean(finals[3]), Long.parseLong(finals[4]));
            nameUser.add(user);
        }


        return nameUser;
    }

}



