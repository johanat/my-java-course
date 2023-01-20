import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Borrowing {


    private String[] finals;
    Book book = new Book(Long.parseLong(finals[0]), "Harry Potter", "J.K rowling", 1997, 256);

    User user = new User("Johana", "Morales", "z303629N", "Molar. calle almendro N.5, 1C");

    LocalDate dateNow = LocalDate.now();
    LocalDate borrowingDate = dateNow.minusDays(3);

    LocalDate returned = LocalDate.now(); // returned =devolucion // borrowingdate = fecha de prestamo
    LocalDate returnedDate = LocalDate.of(2022, 1, 10).plusDays(3);
    float penalty = 5;

    Borrowing(Book book, User user, LocalDate borrowingdate, LocalDate returnedDate) {
        this.book = book;
        this.user = user;
        this.borrowingDate = borrowingdate;
        this.returnedDate = returnedDate;
    }

    Book getBook() {
        return book;
    }

    User getUser() {
        return user;
    }

    LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    LocalDate getReturned() {
        return returned;
    }

    void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    int getDuration() {
        int durationReturn;
        durationReturn = returnedDate.getDayOfYear() - borrowingDate.getDayOfYear();
        return durationReturn;
    }

    float getAmount() {
        LocalDate dateNow = LocalDate.now();
        int day;

        if (dateNow.getDayOfYear() > returnedDate.getDayOfYear()) {
            day = dateNow.getDayOfYear() - returnedDate.getDayOfYear();
            return day * penalty;
        } else {
            return 0;
        }
    }
}
