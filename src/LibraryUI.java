import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    private JPanel printBook;
    private JLabel printOfbook;
    static ArrayList<Book> books = new ArrayList<>();
    boolean update1;


    LibraryUI() {
        this.update1 = update1;
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(new Dimension(670, 600));
        doMainJob(myTitle, myAuthor, myYearOfPublish, numPages, update1);

    }

    public static void main(String[] args) {
        JFrame frame = new LibraryUI();
        frame.setVisible(true);

        String data = "";
        try {
            File file = new File("saveLibrary");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                //noinspection StringConcatenationInLoop
                data += myReader.nextLine();
            }
            books = Utils.fromStringToArrayOfBook(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Utils.printfArray(books);
    }

    private void doMainJob(JTextField myTitle, JTextField myAuthor, JTextField myYearOfPublish, JTextField numPage, boolean update1) {
        addBook.addActionListener(new ActionListener() {

            Utils myUtils = new Utils(printOfbook);

            @Override
            public void actionPerformed(ActionEvent e) {

                if (myTitle.getText().isEmpty() || myAuthor.getText().isEmpty() || myYearOfPublish.getText().isEmpty() || numPages.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Falta campos por llenar");
                } else {
                    if (!update1) {
                        String titleText = myTitle.getText();
                        String authorText = myAuthor.getText();
                        String yearsPublicText = myYearOfPublish.getText();
                        String numPag = numPages.getText();

                        Book book = new Book(myTitle.getText(), myAuthor.getText(), Integer.parseInt(yearsPublicText), Integer.parseInt(numPag));
                        books.add(book);
                        myTitle.setText("");
                        myAuthor.setText("");
                        myYearOfPublish.setText("");
                        numPages.setText("");
                        Utils.printfArray(books);
                    }
                }

                try {
                    FileWriter fw = new FileWriter("C:\\Users\\Darwin\\IdeaProjects\\my-java-course\\saveLibrary");
                    //  String dataUser = fromArrayToString(peopleUser);
                    String dataBook = Utils.fromArrayToStringOfBook(books);

                    fw.write(dataBook);
                    fw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

    }
}
