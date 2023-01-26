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

    private JPanel panel1;
    private JPanel PanelBook;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel printBook;
    private JPanel panelUser;
    private JPanel panelBook;
    private JLabel nameUser;
    private JLabel surnameUser;
    private JLabel dniUser;
    private JLabel directionUser;
    private JPanel printPanel;
    private JLabel printUser;
    private JPanel panelBorrowing;
    private JLabel idBook;
    private JLabel userDni;
    private JLabel dateBorrowing;
    private JLabel dateReturn;
    private JPanel button;
    private JTextField myTitle;
    private JTextField myAuthor;
    private JTextField myYearOfPublish;
    private JTextField numPages;
    private JButton addBook;
    private JLabel printOfBook;
    private JButton addUser;
    private JTextField name;
    private JTextField surname;
    private JTextField dni_User;
    private JTextField direction;
    private JLabel printfUser;
    private JTextField borrowingDate;
    private JTextField returnDate;
    private JButton AddBorrowing;
    private JPanel mainPanel;
    private JLabel printfBorrowing;
    public JComboBox bookComboBox;
    public JComboBox userComboBox;
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<User> myUsers = new ArrayList<>();
    static ArrayList<Borrowing> myBorrowings = new ArrayList<>();
    boolean update1;
    boolean update2;
    boolean update3;


    LibraryUI() {

        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(new Dimension(670, 600));

        Utils.initialize(printOfBook, printfUser, printfBorrowing);

        doMainJobForBook(myTitle, myAuthor, myYearOfPublish, numPages);
        doMainJobForUser(name, surname, dni_User, direction);
        doMainJobForBorrowing(bookComboBox, userComboBox, borrowingDate, returnDate);
    }


    public static void main(String[] args) {
        JFrame frame = new LibraryUI();
        frame.setVisible(true); // to can see the interface
    }

    private void loadBooksFromFileToArray() {
        StringBuilder data = new StringBuilder();
        try {
            File file = new File("saveLibrary");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {

                data.append(myReader.nextLine());
            }
            books = Utils.fromStringToArrayOfBook(data.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Utils.printfArrayOfBooks(books);
    }

    private void loadUserFromFileToArray() {
        StringBuilder data1 = new StringBuilder();
        try {
            File file = new File("saveUser");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                data1.append(myReader.nextLine());
            }
            myUsers = Utils.fromStringToArrayOfUser(data1.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Utils.printfArrayOfUser(myUsers);
    }

    private void loadBorrowingFromFileToArray() {

        StringBuilder data2 = new StringBuilder();
        try {
            File file = new File("saveBorrowing");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                data2.append(myReader.nextLine());
            }
            myBorrowings = Utils.fromStringToArrayOfBorrowing(data2.toString(), books, myUsers);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Utils.printfArrayOfBorrowing(myBorrowings);
    }

    private void doMainJobForBook(JTextField myTitle, JTextField myAuthor, JTextField myYearOfPublish, JTextField numPage) {

        loadBooksFromFileToArray();

        DefaultComboBoxModel model = new DefaultComboBoxModel<Book>();
        for (int i = 0; i < books.size(); i++) {
            model.addElement(books.get(i));
        }
        bookComboBox.setModel(model);
        Book selectedBook = (Book) bookComboBox.getSelectedItem();

        addBook.addActionListener(e -> {

            if (myTitle.getText().isEmpty() || myAuthor.getText().isEmpty() ||
                    myYearOfPublish.getText().isEmpty() || numPage.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Missing fields to fill ");
            } else {
                if (!update1) {
                    long millis = Utils.getId(books);
                    String titleText = myTitle.getText();
                    String authorText = myAuthor.getText();
                    String yearsPublicText = myYearOfPublish.getText();
                    String numPag = numPages.getText();

                    Book book = new Book(millis, titleText, authorText, Integer.parseInt(yearsPublicText), Integer.parseInt(numPag));

                    myTitle.setText("");
                    myAuthor.setText("");
                    myYearOfPublish.setText("");
                    numPages.setText("");

                    books.add(book);

                    model.addElement(book);
                    bookComboBox.setModel(model);

                    Utils.printfArrayOfBooks(books);
                }
            }

            try {
                FileWriter fw = new FileWriter("C:\\Users\\Darwin\\IdeaProjects\\my-java-course\\saveLibrary");
                String dataBook = Utils.fromArrayToStringOfBook(books);

                fw.write(dataBook);
                fw.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void doMainJobForUser(JTextField name, JTextField surname, JTextField dni, JTextField direction) {

        loadUserFromFileToArray();

        DefaultComboBoxModel model = new DefaultComboBoxModel<User>();
        for (int i = 0; i < myUsers.size(); i++) {
            model.addElement(myUsers.get(i));
        }
        userComboBox.setModel(model);
        User selectedUser = (User) userComboBox.getSelectedItem();

        addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().isEmpty() || surname.getText().isEmpty() ||
                        dni.getText().isEmpty() || direction.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Missing fields to fill");
                } else {
                    if (!update2) {
                        String titleText = name.getText();
                        String surnameText = surname.getText();
                        String dniText = dni.getText();
                        String directionText = direction.getText();

                        User user = new User(titleText, surnameText, dniText, directionText);

                        name.setText("");
                        surname.setText("");
                        dni.setText("");
                        direction.setText("");

                        myUsers.add(user);

                        model.addElement(user);
                        userComboBox.setModel(model);

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

    private void doMainJobForBorrowing(JComboBox bookComboBox, JComboBox userComboBox, JTextField borrowingDate, JTextField returnDate) {
        loadBorrowingFromFileToArray();

        //verify what the error is, "missing" fields appear when the fields are filled debug
        AddBorrowing.addActionListener(e -> {
            Book selectedBook = (Book) bookComboBox.getSelectedItem();
            User selectedUser = (User) userComboBox.getSelectedItem();

            if (((Book) bookComboBox.getSelectedItem()).toString2().isEmpty() || ((User) userComboBox.getSelectedItem()).toString2().isEmpty() ||
                    borrowingDate.getText().isEmpty() || returnDate.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Missing fields to fill");
            } else {
                if (!update3) {
                    String idText = String.valueOf(((Book) bookComboBox.getSelectedItem()).getId());
                    String dniText = ((User) userComboBox.getSelectedItem()).DNI;
                    String borrowingDateText = borrowingDate.getText();
                    String returnDateText = returnDate.getText();

                    Borrowing borrowing = new Borrowing(Utils.getBookById(idText, books), Utils.getUserByDni(dniText, myUsers), Utils.fromStringToLocalDate(borrowingDateText), Utils.fromStringToLocalDate(returnDateText));

                    myBorrowings.add(borrowing);
                    borrowingDate.setText("");
                    returnDate.setText("");



                    Utils.printfArrayOfBorrowing(myBorrowings);
                }
            }
            try {
                FileWriter fw = new FileWriter("C:\\Users\\Darwin\\IdeaProjects\\my-java-course\\saveBorrowing");

                String dataBorrowing = Utils.fromArrayToStringOfBorrowing(myBorrowings);

                fw.write(dataBorrowing);
                fw.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    };
}
