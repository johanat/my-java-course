import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import static java.lang.Long.parseLong;

public class Utils {
    public static JList printBook;
    public static JLabel printUser;
    public static JLabel printBorrowing;

    Utils() {
    }

    static public void initialize(JList print_Book, JLabel print_User, JLabel print_Borrowing) {
        printBook = print_Book;
        printUser = print_User;
        printBorrowing = print_Borrowing;
    }

    static long getId(ArrayList<Book> books) {

        long idMax = 0;

        for (Book book : books) {
            if (book.getId() > idMax) {
                idMax = book.getId();
            }
        }
        return idMax + 1;
    }


    public static String fromArrayToStringOfBook(DefaultListModel<Book> books) {
        String general = "";

        int counter = books.size() - 1;

        for (int i = 0; i < books.size(); i++) {
            int TotalBook=books.get(i).getTotalBook();
            long id = books.get(i).getId();
            String title = books.get(i).getTitle();
            String author = String.valueOf(books.get(i).getAuthor());
            int yearOfPublic = books.get(i).getYearsOfPublic();
            int numPag = books.get(i).getNumberOfPag();

            //noinspection StringConcatenationInLoop
            general += (TotalBook + "&"+id + "&" + title + "&" + author + "&" + yearOfPublic + "&" + numPag + "&");
            if (i < counter) {
                general += "##";
            }
        }
        fromStringToArrayOfBook(general);
        return general;
    }

    public static ArrayList<Book> fromStringToArrayOfBook(String general) {

        ArrayList<Book> nameBook = new ArrayList<>();

        if (general.isEmpty()) {
            return nameBook;
        }

        String[] finals;

        String[] parts = general.split("##");

        for (String parte : parts) {
            finals = parte.split("&");
            Book book;
            book = new Book(Integer.parseInt(finals[0]),parseLong(finals[1]), finals[2], finals[3], Integer.parseInt(finals[4]), Integer.parseInt(finals[5]));
            nameBook.add(book);
        }
        return nameBook;
    }

    //functions of User
    public static ArrayList<User> fromStringToArrayOfUser(String date1) {


        ArrayList<User> nameUser = new ArrayList<>();

        if(date1.isEmpty()){
            return nameUser;
        }
        String[] finals;

        String[] parts = date1.split("##");

        for (String parte : parts) {
            finals = parte.split("&");
            User user;
            user = new User(finals[0], finals[1], finals[2], finals[3]);
            nameUser.add(user);
        }
        return nameUser;
    }



    public static String fromArrayToStringOfUser(DefaultListModel<User> myUsers) {
        String general = "";

        int counter = myUsers.size() - 1;

        for (int i = 0; i < myUsers.size(); i++) {

            String name = myUsers.get(i).getName();
            String surname = myUsers.get(i).getSurname();
            String dni = myUsers.get(i).getDNI();
            String direction = myUsers.get(i).direction;

            //noinspection StringConcatenationInLoop
            general += (name + "&" + surname + "&" + dni + "&" + direction + "&");
            if (i < counter) {
                general += "##";
            }
        }
        fromStringToArrayOfUser(general);
        return general;
    }

    // functions of Borrowing

    //Input must be in the format: yyyy-MM-dd. For example, "2005-01-12"
    public static LocalDate fromStringToLocalDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.ENGLISH);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        return LocalDate.parse(stringDate, formatter);
    }


    public static ArrayList<Borrowing> fromStringToArrayOfBorrowing(String date1, DefaultListModel<Book> books, ArrayList<User> myUser) {

        ArrayList<Borrowing> nameBorrowing = new ArrayList<>();

        if(date1.isEmpty()){
            return nameBorrowing;
        }
        String[] finals;

        String[] parts = date1.split("##");

        for (String parte : parts) {
            finals = parte.split("&");
            Borrowing borrowing;
            borrowing = new Borrowing(getBookById(finals[0], books), getUserByDni(finals[1], myUser), fromStringToLocalDate(finals[2]), fromStringToLocalDate(finals[3]));
            nameBorrowing.add(borrowing);
        }
        return nameBorrowing;
    }

    public static String fromArrayToStringOfBorrowing(DefaultListModel<Borrowing> borrowings) {
        String general = "";

        int counter = borrowings.size() - 1;

        for (int i = 0; i < borrowings.size(); i++) {

            Long id = borrowings.get(i).book.getId();
            String dni = borrowings.get(i).user.getDNI();
            LocalDate borrowingDate = borrowings.get(i).borrowingDate;
            LocalDate returnDate = borrowings.get(i).returnedDate;

            //noinspection StringConcatenationInLoop
            general += (id + "&" + dni + "&" + borrowingDate + "&" + returnDate + "&");
            if (i < counter) {
                general += "##";
            }
        }

        return general;
    }


    public static Book getBookById(String idText, DefaultListModel<Book> listBooks) {
        //String.valueOf ---- used to convert number to string
        Book myBook = null;

        for (int i = 0; i < listBooks.size(); i++) {
            Book book = listBooks.get(i);
            if(idText.equals(String.valueOf(listBooks.get(i).getId())) ){
                myBook= book;
            }
        }
        return myBook;
    }

    public static User getUserByDni(String dni, ArrayList<User> myUsers) {
        User myUser = null;
        for (User user : myUsers) {
            if (String.valueOf(user.getDNI()).equals(dni)) {
                myUser = user;
            }
        }
        return myUser;
    }

}
