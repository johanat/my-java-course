import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MyUserInterface extends JFrame {

    private JPanel mainPanel;
    private JTextField name1;
    private JTextField edad;
    private JTextField peso;
    private JRadioButton buttonAutorizacion;
    private JButton addUserButton;
    private JPanel tituloGeneral;
    private JLabel print;
    ArrayList<Persona> peopleUsuare = new ArrayList<>(); // (variable global) lo ven todos y (variables locales)  debe estar dentro de un metodo y sera manejados solo los atributos de dicho metodo  ejemplo  MyUserInterface es un metodo mas si quieres que solo este metodo vea este array debes ponerlo dentro.


    MyUserInterface() {


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
                            " Autorized: " + autorizacionC + "<br/>" +
                            "________________" + "<br/>";

                    print.setText(general);
                }
                name1.setText("");
                edad.setText("");
                peso.setText("");

            }

        });
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
    }

    ;


    public static void main(String[] args) {
        JFrame frame = new MyUserInterface();
        frame.setVisible(true);
    }

}
