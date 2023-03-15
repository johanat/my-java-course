
import java.time.LocalDate;


public class Borrowing {




    private  long id;
    private int totalBook;
    private  String title;
    private  String author;
    private int yearsOfPublic;
    private int numberOfPag;

    Book  book;
    User user;

    LocalDate borrowingDate;
    LocalDate returnedDate;

    Borrowing(int id, Book book, User user, LocalDate borrowingDate, LocalDate returnedDate) {
        this. book = new Book(totalBook, this.id,title,author, yearsOfPublic,numberOfPag);
        this.id = id;
        this.book = book;
        this.user = user;
        this.borrowingDate = borrowingDate;
        this.returnedDate = returnedDate;
    }


    public long getId() {
        return id;
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
        return "<html>  Book Id : "+book.getId()+"<br/>" +"Name: "+user.name+"<br/>" +" DNI: " + getUser().DNI + "<br/>" + " Borrowing: " + getBorrowingDate() + "<br/>" + "ReturnedDate: " + getReturned() + "<br/>" + "____________________" + "<br/>";
    }

}




