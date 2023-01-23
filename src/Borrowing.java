import java.time.LocalDate;


public class Borrowing {


    Book book;
    User user;

    LocalDate borrowingDate;
    LocalDate returned = LocalDate.now();
    LocalDate returnedDate;

    Borrowing(Book book, User user, LocalDate borrowingDate, LocalDate returnedDate) {
        this.book = book;
        this.user = user;
        this.borrowingDate = borrowingDate;
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


    @Override
    public String toString() {
        return "<html> " + " Id: " + getBook().getId() + "<br/>" + " DNI: " + getUser().DNI + "<br/>" + " Borrowing: " + getBorrowingDate() + "<br/>" + "ReturnedDate: " + getReturned() + "<br/>" + "____________________" + "<br/>";
    }
}
