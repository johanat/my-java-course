import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    ArrayList<Borrowing> borrowings;


    Library() {
        borrowings = new ArrayList<>(); //inicializar: cuando se le da un valor inicial a la variable new si es un objeto o = si es una variable y su valor correspondiente.
    }

    void realizeBorrowing(Book book, User user, LocalDate borrowingDate, LocalDate returnedDate) {

        borrowings.add(new Borrowing(0, book, user, borrowingDate, returnedDate));
    }

    List<Borrowing> getBorrowings() {
        return borrowings;
    }

    List<Borrowing> getBorrowingUser(User user) {
        return borrowings;
    }

    List<Borrowing> getBorrowingUser() {
        return borrowings;
    }

    float getTotalDebt() {
        float totalPenalty = 0;
        return totalPenalty;
    }
}
