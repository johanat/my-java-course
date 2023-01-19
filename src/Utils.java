import javax.swing.*;
import java.util.ArrayList;

public class Utils {
    public static JLabel label;

    Utils(JLabel label){
        this.label=label;
    }


    public static String fromArrayToStringOfBook(ArrayList<Book> books) {
        String general = "";

        int counter = books.size() - 1;

        for (int i = 0; i < books.size(); i++) {
            String title = books.get(i).getTitle();
            String author = String.valueOf(books.get(i).getAuthor());
            int yearOfPublic = books.get(i).getYearsOfPublic();
            int numPag = books.get(i).getNumberOfPag();

            //noinspection StringConcatenationInLoop
            general += (title + "&" + author + "&" + yearOfPublic + "&" + numPag + "&");
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
            book = new Book(finals[0], finals[1],Integer.parseInt(finals[2]),Integer.parseInt(finals[3]));
            nameBook.add(book);
        }
        return nameBook;
    }
    static void printfArray(ArrayList<Book> books) {


        String printfVariable = "";

        for (Book book : books) {

            //noinspection StringConcatenationInLoop
            printfVariable += book.toString();
        }
         label.setText(printfVariable);
    }
}
