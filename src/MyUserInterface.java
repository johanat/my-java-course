import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyUserInterface extends JFrame  {


    private JPanel mainPanel;
    private JTextField Height;
    private JTextField weight;
    private JButton IMCButton;
    private JLabel resultado;
    private JButton borrador;


    MyUserInterface() {
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(new Dimension(500, 300));


        Height.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });


        weight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        IMCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String peso = weight.getText();
                float  numberWeight = Float.parseFloat(peso);


                String altura = Height.getText();
                float numberHeight = Float.parseFloat(altura);
                float valor = numberHeight * numberHeight;

                float resultImc = (numberWeight/valor);

                String finaly = String.valueOf(resultImc);
                resultado.setText("IMC = "+finaly);

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new MyUserInterface();
        frame.setVisible(true);
    }

}
