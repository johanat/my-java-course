import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;


public class Utils {
   // public static JList printBook;
    //public static JLabel printUser;
    //public static JLabel printBorrowing;

    Utils() {
    }


    static long getId(DefaultListModel<Book> books) {

        long idMax = 0;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() > idMax) {
                idMax = books.get(i).getId();
            }
        }
        return idMax + 1;
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

        if (date1.isEmpty()) {
            return nameBorrowing;
        }
        String[] finals;

        String[] parts = date1.split("##");

        for (String parte : parts) {
            finals = parte.split("&");
            Borrowing borrowing;
            borrowing = new Borrowing(0, getBookById(finals[0], books), getUserByDni(finals[1], myUser), fromStringToLocalDate(finals[2]), fromStringToLocalDate(finals[3]));
            nameBorrowing.add(borrowing);
        }
        return nameBorrowing;
    }

    public static Book getBookById(String idText, DefaultListModel<Book> listBooks) {
        //String.valueOf ---- used to convert number to string
        Book myBook = null;

        for (int i = 0; i < listBooks.size(); i++) {
            Book book = listBooks.get(i);
            if (idText.equals(String.valueOf(listBooks.get(i).getId()))) {
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

    static public String fixDateBorrowing(String borrowingDate) {
        String[] parties = borrowingDate.split("-");
        String year = parties[0];
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
        String fixedDate = year + "-" + month + "-" + day;

        return fixedDate;
    }

    static public String fixReturnDate(String returnDate) {
        String[] parties1 = returnDate.split("-");
        String year = parties1[0];
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
        String fixReturnDate;
        fixReturnDate = year + "-" + monthR + "-" + dayR;

        return fixReturnDate;

    }
}
