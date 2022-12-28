import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    Library() {
        books.add(new Book("Harry Potter", "J.K. Rowling", 1997, 3665));
        books.add(new Book("El Señor de los anillos ", "J.R. Tolkien", 1954, 576));
        books.add(new Book("El Hombre que tenia miedo a vivir", "Migel Montero", 2022, 210));
        books.add(new Book("Don Quijote de la Mancha", "Miguel de Cervantes", 1605, 1345));

    }

    void addANewBook(Book littleBook) {
        books.add(littleBook);
    }

    void removeAnExistingBook(Book book) {
        books.remove(book);
    }

    Book searchABookByTitleOrAuthor(String titleOrAuthor) {

        for (int i = 0; i < books.size(); i++) {
            if (titleOrAuthor == books.get(i).getTitle() || titleOrAuthor == books.get(i).getAuthor()) {
                return books.get(i);
            }
        }
        return null;
    }

    void displayTheInventoryCompleteLibrary() {
        for(int i=0; i< books.size(); i++){
            System.out.println(books.get(i));
        }
    }
}
