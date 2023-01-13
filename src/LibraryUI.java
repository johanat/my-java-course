import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LibraryUI extends JFrame {

    private JPanel mainPanel;

    LibraryUI() {
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(new Dimension(670, 600));
    }

    public static void main(String[] args) {
        JFrame frame = new LibraryUI();
        frame.setVisible(true);
    }

}
