import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyUserInterface extends JFrame{

    private JPanel mainPanel;
    private JTextField txtInput;
    private JButton btnClick;
    private JLabel myLabel;

    MyUserInterface() {
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(new Dimension(600, 400));
        btnClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Read the input text
                String myText = txtInput.getText();
                myLabel.setText(myText);
                txtInput.setText("");
            }
        });
    }

    public static void main (String [] args) {
        JFrame frame = new MyUserInterface();
        frame.setVisible(true);
    }
}
