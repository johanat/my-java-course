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
    private JLabel printOfBook;
    private JPanel panelUser;
    private JPanel panelBook;
    private JButton addUser;
    private JTextField name;
    private JTextField surname;
    private JTextField dni;
    private JTextField direction;
    private JLabel nameUser;
    private JLabel surnameUser;
    private JLabel dniUser;
    private JLabel directionUser;
    private JPanel printPanel;
    private JLabel printfUser;
    private JLabel printUser;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField1;
    private JButton button1;
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<User> myUsers = new ArrayList<>();
    boolean update1;
    boolean update2;


    LibraryUI() {

        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(new Dimension(670, 600));
        Utils myUtils = new Utils(printOfBook, printfUser);

        doMainJobForBook(myTitle, myAuthor, myYearOfPublish, numPages, update1);
        doMainJobForUser(name, surname, dni, direction);

    }

    public static void main(String[] args) {
        JFrame frame = new LibraryUI();
        frame.setVisible(true); // to can see the interface

        String data = "";
        try {
            File file = new File("saveLibrary");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {

                data += myReader.nextLine();
            }
            books = Utils.fromStringToArrayOfBook(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Utils.printfArrayOfBooks(books);

        String data1 = "";
        try {
            File file = new File("saveUser");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                data1 += myReader.nextLine();
            }
            myUsers = Utils.fromStringToArrayOfUser(data1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Utils.printfArrayOfUser(myUsers);
    }

    private void doMainJobForBook(JTextField myTitle, JTextField myAuthor, JTextField myYearOfPublish, JTextField numPage, boolean update1) {
        addBook.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (myTitle.getText().isEmpty() || myAuthor.getText().isEmpty() ||
                        myYearOfPublish.getText().isEmpty() || numPages.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Missing fields to fill ");
                } else {
                    if (!update1) {
                        long millis = Utils.getId(books);
                        String titleText = myTitle.getText();
                        String authorText = myAuthor.getText();
                        String yearsPublicText = myYearOfPublish.getText();
                        String numPag = numPages.getText();

                        Book book = new Book(millis, myTitle.getText(), myAuthor.getText(), Integer.parseInt(yearsPublicText), Integer.parseInt(numPag));
                        books.add(book);
                        myTitle.setText("");
                        myAuthor.setText("");
                        myYearOfPublish.setText("");
                        numPages.setText("");
                        Utils.printfArrayOfBooks(books);
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

    private void doMainJobForUser(JTextField name, JTextField surname, JTextField dni, JTextField direction) {
        addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().isEmpty() || surname.getText().isEmpty() ||
                        dni.getText().isEmpty() || direction.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Missing fields to fill");
                } else {
                    if (!update2) {
                        String titleText = name.getText();
                        String authorText = surname.getText();
                        String yearsPublicText = dni.getText();
                        String numPag = direction.getText();

                        User user = new User(name.getText(), surname.getText(), dni.getText(), direction.getText());
                        myUsers.add(user);
                        name.setText("");
                        surname.setText("");
                        dni.setText("");
                        direction.setText("");
                        Utils.printfArrayOfUser(myUsers);
                    }
                }
                try {
                    FileWriter fw = new FileWriter("C:\\Users\\Darwin\\IdeaProjects\\my-java-course\\saveUser");

                    String dataUser = Utils.fromArrayToStringOfUser(myUsers);

                    fw.write(dataUser);
                    fw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

    };
}
