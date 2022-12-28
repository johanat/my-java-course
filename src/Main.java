
public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Book myBook;

        System.out.println("\n");
        library.displayTheInventoryCompleteLibrary();
        library.addANewBook(new Book("La culpa es de la vaca", "Jaime Espinoza", 2021, 200));

        myBook = library.searchABookByTitleOrAuthor("El Señor de los anillos ");

        if (myBook == null) {
            System.out.println("It hasn't found the book");
        } else {
            System.out.println("It has found ===>" + myBook);
        }

        library.removeAnExistingBook(myBook);
        System.out.println("\n");
        library.displayTheInventoryCompleteLibrary();

    }
}


