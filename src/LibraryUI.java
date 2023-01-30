import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    private JButton addUser;
    private JTextField name;
    private JTextField surname;
    private JTextField dni_User;
    private JTextField direction;
    private JTextField borrowingDate;
    private JTextField returnDate;
    private JButton AddBorrowing;
    private JPanel mainPanel;
    public JComboBox bookComboBox;
    public JComboBox userComboBox;
    private JList list1Book;
    private JButton removeBook;
    private JList list1User;
    private JButton removeUser;
    private JList list1Borrowing;
    private JButton removeBorrowing;
    static ArrayList<Book> myBooks = new ArrayList<>();
    static ArrayList<User> myUsers = new ArrayList<>();
    DefaultListModel<Book> dlmBook = new DefaultListModel<>();
    DefaultListModel<User> dlmUser = new DefaultListModel<>();
    DefaultListModel<Borrowing> dlmBorrowing = new DefaultListModel<>();
    static ArrayList<Borrowing> myBorrowings = new ArrayList<>();
    DefaultComboBoxModel modelUser = new DefaultComboBoxModel<User>();
    boolean update1;
    boolean update2;
    boolean update3;


    LibraryUI() {

        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(new Dimension(670, 600));

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
            myBooks = Utils.fromStringToArrayOfBook(data.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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
    }

    private void loadBorrowingFromFileToArray() {

        StringBuilder data2 = new StringBuilder();
        try {
            File file = new File("saveBorrowing");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                data2.append(myReader.nextLine());
            }
            myBorrowings = Utils.fromStringToArrayOfBorrowing(data2.toString(), dlmBook, myUsers);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void doMainJobForBook(JTextField myTitle, JTextField myAuthor, JTextField myYearOfPublish, JTextField numPage) {

        loadBooksFromFileToArray();

        DefaultComboBoxModel model = new DefaultComboBoxModel<Book>();
        for (int i = 0; i < myBooks.size(); i++) {
            model.addElement(myBooks.get(i));
        }
        bookComboBox.setModel(model);
        Book selectedBook = (Book) bookComboBox.getSelectedItem();


        for (int i = 0; i < myBooks.size(); i++) {
            dlmBook.add(i, myBooks.get(i));
        }
        list1Book.setModel(dlmBook);

        list1Book.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                list1Book = (JList) e.getSource();

                int index = list1Book.locationToIndex(e.getPoint());

                myTitle.setText(dlmBook.get(index).getTitle());
                myAuthor.setText(dlmBook.get(index).getAuthor());
                myYearOfPublish.setText(String.valueOf(dlmBook.get(index).getYearsOfPublic()));
                numPage.setText(String.valueOf(dlmBook.get(index).getNumberOfPag()));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        removeBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dlmBook.remove(list1Book.getSelectedIndex());

                myTitle.setText("");
                myAuthor.setText("");
                myYearOfPublish.setText("");
                numPages.setText("");
                saveArrayInTheFileBook(dlmBook);
            }
        });

        addBook.addActionListener(e -> {

            if (myTitle.getText().isEmpty() || myAuthor.getText().isEmpty() ||
                    myYearOfPublish.getText().isEmpty() || numPage.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Missing fields to fill ");
            } else {
                if (!update1) {
                    long millis = Utils.getId(myBooks);
                    String titleText = myTitle.getText();
                    String authorText = myAuthor.getText();
                    String yearsPublicText = myYearOfPublish.getText();
                    String numPag = numPages.getText();

                    Book book = new Book(millis, titleText, authorText, Integer.parseInt(yearsPublicText), Integer.parseInt(numPag));

                    myTitle.setText("");
                    myAuthor.setText("");
                    myYearOfPublish.setText("");
                    numPages.setText("");

                    model.addElement(book);
                    dlmBook.addElement(book);
                    bookComboBox.setModel(model);

                    saveArrayInTheFileBook(dlmBook);
                }
            }
        });
    }

    void saveArrayInTheFileBook(DefaultListModel<Book> dlmBook) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Darwin\\IdeaProjects\\my-java-course\\saveLibrary");
            //  String dataBook = Utils.fromArrayToStringOfBook(books);
            String dataBook = Utils.fromArrayToStringOfBook(dlmBook);


            fw.write(dataBook);
            fw.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    void saveArrayInTheFileUser(DefaultListModel<User> dlmUser) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Darwin\\IdeaProjects\\my-java-course\\saveUser");

            String dataUser = Utils.fromArrayToStringOfUser(dlmUser);

            fw.write(dataUser);
            fw.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    void saveArrayInTheFileBorrowing(DefaultListModel<Borrowing> dlmBorrowing) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Darwin\\IdeaProjects\\my-java-course\\saveBorrowing");

            String dataBorrowing = Utils.fromArrayToStringOfBorrowing(dlmBorrowing);

            fw.write(dataBorrowing);
            fw.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void doMainJobForUser(JTextField name, JTextField surname, JTextField dni, JTextField direction) {

        loadUserFromFileToArray();


        for (int i = 0; i < myUsers.size(); i++) {
            modelUser.addElement(myUsers.get(i));
        }
        userComboBox.setModel(modelUser);

        User selectedUser = (User) userComboBox.getSelectedItem();


        for (int i = 0; i < myUsers.size(); i++) {
            dlmUser.add(i, myUsers.get(i));
        }
        list1User.setModel(dlmUser);

        list1User.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                list1User = (JList) e.getSource();

                int index = list1User.locationToIndex(e.getPoint());

                name.setText(dlmUser.get(index).name);
                surname.setText(dlmUser.get(index).surname);
                dni.setText(dlmUser.get(index).DNI);
                direction.setText(dlmUser.get(index).direction);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        removeUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlmUser.remove(list1User.getSelectedIndex());

                name.setText("");
                surname.setText("");
                dni.setText("");
                direction.setText("");
                saveArrayInTheFileUser(dlmUser);
            }
        });

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

                        modelUser.addElement(user);
                        dlmUser.addElement(user);
                        userComboBox.setModel(modelUser);

                        saveArrayInTheFileUser(dlmUser);
                    }
                }
            }
        });
    };

    private void doMainJobForBorrowing(JComboBox bookComboBox, JComboBox userComboBox, JTextField borrowingDate, JTextField returnDate) {


        loadBorrowingFromFileToArray();

        for (int i = 0; i < myBorrowings.size(); i++) {
            dlmBorrowing.add(i, myBorrowings.get(i));
        }
        list1Borrowing.setModel(dlmBorrowing);

        list1Borrowing.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                list1Borrowing = (JList) e.getSource();

                int index = list1Borrowing.locationToIndex(e.getPoint());

                borrowingDate.setText(dlmBorrowing.get(list1Borrowing.getSelectedIndex()).borrowingDate.toString());
                returnDate.setText(dlmBorrowing.get(list1Borrowing.getSelectedIndex()).returnedDate.toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        removeBorrowing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlmBorrowing.remove(list1Borrowing.getSelectedIndex());

                borrowingDate.setText("");
                returnDate.setText("");

                saveArrayInTheFileBorrowing(dlmBorrowing);
            }
        });

        //verify what the error is, "missing" fields appear when the fields are filled debug
        AddBorrowing.addActionListener(e -> {
            Book selectedBook = (Book) bookComboBox.getSelectedItem();
            User selectedUsers = (User) userComboBox.getSelectedItem();

            if (((Book) bookComboBox.getSelectedItem()).toString2().isEmpty() || ((User) userComboBox.getSelectedItem()).toString2().isEmpty() ||
                    borrowingDate.getText().isEmpty() || returnDate.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Missing fields to fill");
            } else {
                if (!update3) {
                    String idText = String.valueOf(((Book) bookComboBox.getSelectedItem()).getId());
                    String dniText = ((User) userComboBox.getSelectedItem()).DNI;
                    String borrowingDateText = borrowingDate.getText();
                    String returnDateText = returnDate.getText();

                    Borrowing borrowing = new Borrowing(Utils.getBookById(idText, dlmBook), Utils.getUserByDni(dniText, myUsers), Utils.fromStringToLocalDate(borrowingDateText), Utils.fromStringToLocalDate(returnDateText));

                    borrowingDate.setText("");
                    returnDate.setText("");

                    myBorrowings.add(borrowing);
                    dlmBorrowing.addElement(borrowing);
                    saveArrayInTheFileBorrowing(dlmBorrowing);
                }
            }
        });
    };
}
