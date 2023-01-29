import javax.swing.*;
import java.time.LocalDate;


public class Borrowing {


    Book  book;
    User user;

    LocalDate borrowingDate;
    LocalDate returnedDate;

    Borrowing( Book book, User user, LocalDate borrowingDate, LocalDate returnedDate) {
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
        return returnedDate;
    }


    @Override

    public String toString() {
        return "<html> Id: "+book.getId() +"<br/>" +"Name: "+user.name+"<br/>" +" DNI: " + getUser().DNI + "<br/>" + " Borrowing: " + getBorrowingDate() + "<br/>" + "ReturnedDate: " + getReturned() + "<br/>" + "____________________" + "<br/>";
    }
}




