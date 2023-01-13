import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        doMainJob();
    }

    public static void main(String[] args) {
        JFrame frame = new LibraryUI();
        frame.setVisible(true);
    }

    private void doMainJob() {
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(myTitle.getText().isEmpty() ||  myAuthor.getText().isEmpty() || myYearOfPublish.getText().isEmpty()|| numPages.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Falta campos por llenar");
                }
                else{

                    String data = "";
                    try {
                        File file = new File("saveLibrary");
                        Scanner myReader = new Scanner(file);
                        while (myReader.hasNextLine()) {
                            //noinspection StringConcatenationInLoop
                            data += myReader.nextLine();
                        }
                        //LibraryInterface.books = LibraryInterface(data);

                    } catch (FileNotFoundException e2) {
                        throw new RuntimeException(e2);
                    }

                }
            }
        });
    }

}
