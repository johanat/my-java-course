public class Book {
    private String title;
    private String author;
    private int yearOfPublication;
    private int numberOfPag;

    Book(String title, String author, int yearOfPublication, int numberOfPag) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPag = numberOfPag;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public void setNumberOfPag(int numberOfPag) {
        this.numberOfPag = numberOfPag;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public int getNumberOfPag() {
        return numberOfPag;
    }

    @Override
    public String toString() {
        return title+" - "+author;
    }
}
