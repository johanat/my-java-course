import com.raven.datechooser.DateChooser;
import com.raven.datechooser.SelectedDate;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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
    // private JTextField borrowingDate;
    // private JTextField returnDate;
    private JButton AddBorrowing;
    private JPanel mainPanel;
    public JComboBox bookComboBox;
    public JComboBox userComboBox;
    private JList booksJList;
    private JButton removeBook;
    private JList usersJList;
    private JButton removeUser;
    private JList borrowingsJList;
    private JButton removeBorrowing;
    private DateChooser caledarBorrowing;
    private DateChooser caledarReturn;
    private JTextField bookSearcher;
    private JTextField userSearcher;
    private DateChooser myCalendar;
    static ArrayList<Book> myBooks = new ArrayList<>();
    static ArrayList<User> myUsers = new ArrayList<>();
    DefaultListModel<Book> booksListModel = new DefaultListModel<>();
    DefaultListModel<User> usersListModel = new DefaultListModel<>();
    DefaultListModel<Borrowing> borrowingsListModel = new DefaultListModel<>();
    static ArrayList<Borrowing> myBorrowings = new ArrayList<>();
    DefaultComboBoxModel usersComboBoxModel = new DefaultComboBoxModel<User>();
    boolean update1;
    boolean update2;
    boolean update3;

    DefaultComboBoxModel booksComboBoxModel = new DefaultComboBoxModel<Book>();


    LibraryUI() {

        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(new Dimension(670, 600));

        doMainJobForBook(myTitle, myAuthor, myYearOfPublish, numPages);
        doMainJobForUser(name, surname, dni_User, direction);
        doMainJobForBorrowing(bookComboBox);
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
            myBorrowings = Utils.fromStringToArrayOfBorrowing(data2.toString(), booksListModel, myUsers);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void doMainJobForBook(JTextField myTitle, JTextField myAuthor, JTextField myYearOfPublish, JTextField numPage) {

        loadBooksFromFileToArray();

        for (int i = 0; i < myBooks.size(); i++) {
            booksComboBoxModel.addElement(myBooks.get(i));
        }
        bookComboBox.setModel(booksComboBoxModel);
        Book selectedBook = (Book) bookComboBox.getSelectedItem();


        for (int i = 0; i < myBooks.size(); i++) {
            booksListModel.add(i, myBooks.get(i));
        }
        booksJList.setModel(booksListModel);

        booksJList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                booksJList = (JList) e.getSource();

                int index = booksJList.locationToIndex(e.getPoint());

                myTitle.setText(booksListModel.get(index).getTitle());
                myAuthor.setText(booksListModel.get(index).getAuthor());
                myYearOfPublish.setText(String.valueOf(booksListModel.get(index).getYearsOfPublic()));
                numPage.setText(String.valueOf(booksListModel.get(index).getNumberOfPag()));
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

                booksListModel.remove(booksJList.getSelectedIndex());

                myTitle.setText("");
                myAuthor.setText("");
                myYearOfPublish.setText("");
                numPages.setText("");
                saveArrayInTheFileBook(booksListModel);
            }
        });
        bookSearcher.addKeyListener(new KeyListener() {


            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String frase = bookSearcher.getText();

                booksListModel.removeAllElements();
                for (int i = 0; i < myBooks.size(); i++) {
                    if (myBooks.get(i).getTitle().contains(frase)) {
                        booksListModel.addElement(myBooks.get(i));
                    }
                    booksJList.setModel(booksListModel);
                }
            }
        });

        addBook.addActionListener(e -> {

            if (myTitle.getText().isEmpty() || myAuthor.getText().isEmpty() || myYearOfPublish.getText().isEmpty() || numPage.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Missing fields to fill ");
            } else {
                if (!update1) {
                    int totalBooks = 5;
                    long millis = Utils.getId(myBooks);
                    String titleText = myTitle.getText();
                    String authorText = myAuthor.getText();
                    String yearsPublicText = myYearOfPublish.getText();
                    String numPag = numPages.getText();

                    Book book = new Book( totalBooks,millis, titleText, authorText, Integer.parseInt(yearsPublicText), Integer.parseInt(numPag));

                    myTitle.setText("");
                    myAuthor.setText("");
                    myYearOfPublish.setText("");
                    numPages.setText("");

                    booksComboBoxModel.addElement(book);
                    booksListModel.addElement(book);
                    bookComboBox.setModel(booksComboBoxModel);


                    saveArrayInTheFileBook(booksListModel);
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
            usersComboBoxModel.addElement(myUsers.get(i));
        }
        userComboBox.setModel(usersComboBoxModel);


        for (int i = 0; i < myUsers.size(); i++) {
            usersListModel.add(i, myUsers.get(i));
        }
        usersJList.setModel(usersListModel);

        usersJList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                usersJList = (JList) e.getSource();

                int index1 = usersJList.locationToIndex(e.getPoint());


                name.setText(usersListModel.get(index1).name);
                surname.setText(usersListModel.get(index1).surname);
                dni.setText(usersListModel.get(index1).DNI);
                direction.setText(usersListModel.get(index1).direction);
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
                usersListModel.remove(usersJList.getSelectedIndex());

                name.setText("");
                surname.setText("");
                dni.setText("");
                direction.setText("");
                saveArrayInTheFileUser(usersListModel);
            }
        });
        userSearcher.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                String frase = userSearcher.getText();

                usersListModel.removeAllElements();
                for (int i = 0; i < myUsers.size(); i++) {
                    if (myUsers.get(i).name.contains(frase)) {
                        usersListModel.addElement(myUsers.get(i));
                    }
                    usersJList.setModel(usersListModel);
                }
            }

        });

        addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().isEmpty() || surname.getText().isEmpty() || dni.getText().isEmpty() || direction.getText().isEmpty()) {
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

                        usersComboBoxModel.addElement(user);
                        usersListModel.addElement(user);
                        userComboBox.setModel(usersComboBoxModel);

                        saveArrayInTheFileUser(usersListModel);
                    }
                }
            }
        });
    }

    ;


    private void doMainJobForBorrowing(JComboBox bookComboBox) {


        loadBorrowingFromFileToArray();

        for (int i = 0; i < myBorrowings.size(); i++) {
            borrowingsListModel.add(i, myBorrowings.get(i));
        }
        borrowingsJList.setModel(borrowingsListModel);

        borrowingsJList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                borrowingsJList = (JList) e.getSource();

                int index = borrowingsJList.locationToIndex(e.getPoint());


                int selectedIndexBook = findComboBoxIndexById(borrowingsListModel.get(index));
                bookComboBox.setSelectedIndex(selectedIndexBook);


                int selectedIndexUser = findComboBoxIndexByDni(borrowingsListModel.get(index));
                userComboBox.setSelectedIndex(selectedIndexUser);


                SelectedDate selectedDateBorrowing = new SelectedDate();
                selectedDateBorrowing.setDay(borrowingsListModel.get(index).borrowingDate.getDayOfMonth() );
                selectedDateBorrowing.setMonth(borrowingsListModel.get(index).borrowingDate.getMonthValue());
                selectedDateBorrowing.setYear(borrowingsListModel.get(index).borrowingDate.getYear());
                caledarBorrowing.setSelectedDate(selectedDateBorrowing);

                SelectedDate selectedDateReturn= new SelectedDate();
                selectedDateReturn.setDay(borrowingsListModel.get(index).returnedDate.getDayOfMonth());
                selectedDateReturn.setMonth(borrowingsListModel.get(index).returnedDate.getMonthValue());
                selectedDateReturn.setYear(borrowingsListModel.get(index).returnedDate.getYear());

                caledarReturn.setSelectedDate(selectedDateReturn);




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
                borrowingsListModel.remove(borrowingsJList.getSelectedIndex());
                saveArrayInTheFileBorrowing(borrowingsListModel);
            }
        });


        //verify what the error is, "missing" fields appear when the fields are filled debug
        AddBorrowing.addActionListener(e -> {
            Book selectedBook = (Book) bookComboBox.getSelectedItem();
            User selectedUsers = (User) userComboBox.getSelectedItem();

            if (!update3) {
                String idText = String.valueOf(((Book) bookComboBox.getSelectedItem()).getId());
                String dniText = ((User) userComboBox.getSelectedItem()).DNI;
                String borrowingDateText = caledarBorrowing.getSelectedDate().getYear() + "-" + caledarBorrowing.getSelectedDate().getMonth() + "-" + caledarBorrowing.getSelectedDate().getDay();
                ;
                String returnDate1 = caledarReturn.getSelectedDate().getYear() + "-" + caledarReturn.getSelectedDate().getMonth() + "-" + caledarReturn.getSelectedDate().getDay();
                ;

                String[] parties = borrowingDateText.split("-");
                String month = parties[1];
                String day = parties[2];
                if (Integer.parseInt(month) < 10) {
                    month = "0" + month;
                } else {
                    month = month;
                }
                if (Integer.parseInt(day) < 10) {
                    day = "0" + day;
                } else {
                    day = day;
                }
                borrowingDateText = caledarBorrowing.getSelectedDate().getYear() + "-" + month + "-" + day;

                String[] parties1 = returnDate1.split("-");
                String monthR = parties1[1];
                String dayR = parties1[2];
                if (Integer.parseInt(monthR) < 10) {
                    monthR = "0" + monthR;
                } else {
                    monthR = monthR;
                }
                if (Integer.parseInt(dayR) < 10) {
                    dayR = "0" + dayR;
                } else {
                    dayR = dayR;
                }
                returnDate1 = caledarReturn.getSelectedDate().getYear() + "-" + monthR + "-" + dayR;

                Borrowing borrowing = new Borrowing(Utils.getBookById(idText, booksListModel), Utils.getUserByDni(dniText, myUsers), Utils.fromStringToLocalDate(borrowingDateText), Utils.fromStringToLocalDate(returnDate1));

                myBorrowings.add(borrowing);
                borrowingsListModel.addElement(borrowing);
                saveArrayInTheFileBorrowing(borrowingsListModel);
            }
        });
    };

    int findComboBoxIndexById(Borrowing borrowingsListSelected) {
        long bookId = borrowingsListSelected.book.getId();

        for (int i = 0; i < booksListModel.getSize(); i++) {
            Book book = (Book) booksComboBoxModel.getElementAt(i);

            if (bookId == book.getId()) {
                return i;
            }
        }
        return 0;
    }

    int findComboBoxIndexByDni(Borrowing borrowingsListSelected) {

        String dni = borrowingsListSelected.user.DNI;
        for (int i = 0; i < usersComboBoxModel.getSize(); i++) {
            User user = (User) usersComboBoxModel.getElementAt(i);

            if (dni.equals(user.DNI)) {
                return i;
            }
        }
        return 0;
    }
}
