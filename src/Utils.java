import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import static java.lang.Long.parseLong;

public class Utils {
    public static JLabel printBook;
    public static JLabel printUser;
    public static JLabel printBorrowing;

    Utils() {
    }

    static public void initialize(JLabel print_Book, JLabel print_User, JLabel print_Borrowing) {
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


    public static String fromArrayToStringOfBook(ArrayList<Book> books) {
        String general = "";

        int counter = books.size() - 1;

        for (int i = 0; i < books.size(); i++) {
            long id = books.get(i).getId();
            String title = books.get(i).getTitle();
            String author = String.valueOf(books.get(i).getAuthor());
            int yearOfPublic = books.get(i).getYearsOfPublic();
            int numPag = books.get(i).getNumberOfPag();

            //noinspection StringConcatenationInLoop
            general += (id + "&" + title + "&" + author + "&" + yearOfPublic + "&" + numPag + "&");
            if (i < counter) {
                general += "##";
            }
        }
        fromStringToArrayOfBook(general);
        return general;
    }

    public static ArrayList<Book> fromStringToArrayOfBook(String general) {

        ArrayList<Book> nameBook = new ArrayList<>();
        String[] finals;

        String[] parts = general.split("##");

        for (String parte : parts) {
            finals = parte.split("&");
            Book book;
            book = new Book(parseLong(finals[0]), finals[1], finals[2], Integer.parseInt(finals[3]), Integer.parseInt(finals[4]));
            nameBook.add(book);
        }
        return nameBook;
    }

    static void printfArrayOfBooks(ArrayList<Book> books) {


        String printfVariable = "";

        for (Book book : books) {

            //noinspection StringConcatenationInLoop
            printfVariable += book.toString();
        }
        printBook.setText(printfVariable);
    }

    //functions of User
    public static ArrayList<User> fromStringToArrayOfUser(String date1) {

        ArrayList<User> nameUser = new ArrayList<>();
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

    static void printfArrayOfUser(ArrayList<User> users) {


        StringBuilder printfVariable = new StringBuilder();

        for (User user : users) {
            printfVariable.append(user.toString());
        }
        printUser.setText(printfVariable.toString());
    }

    public static String fromArrayToStringOfUser(ArrayList<User> users) {
        String general = "";

        int counter = users.size() - 1;

        for (int i = 0; i < users.size(); i++) {

            String name = users.get(i).getName();
            String surname = users.get(i).getSurname();
            String dni = users.get(i).getDNI();
            String direction = users.get(i).direction;

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


    public static ArrayList<Borrowing> fromStringToArrayOfBorrowing(String date1, ArrayList<Book> books, ArrayList<User> myUser) {

        ArrayList<Borrowing> nameBorrowing = new ArrayList<>();
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

    public static String fromArrayToStringOfBorrowing(ArrayList<Borrowing> borrowings, ArrayList<Book> books, ArrayList<User> myUsers) {
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
        fromStringToArrayOfBorrowing(general, books, myUsers);
        return general;
    }

    static void printfArrayOfBorrowing(ArrayList<Borrowing> borrowings) {


        StringBuilder printfVariable = new StringBuilder();

        for (Borrowing borrowing : borrowings) {
            printfVariable.append(borrowing.toString());
        }
        printBorrowing.setText(printfVariable.toString());
    }


    public static Book getBookById(String idText, ArrayList<Book> books) {
        //String.valueOf ---- used to convert number to string
        Book myBook = null;
        for (Book book : books) {
            if (String.valueOf(book.getId()).equals(idText)) {
                myBook = book;
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
