import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LibraryUI extends JFrame {

    private JPanel mainPanel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JTextField myTitle;
    private JTextField myAuthor;
    private JTextField myYearOfPublish;
    private JTextField numPages;
    private JButton addBook;

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
