public class Book {

    private  int TotalBook;
    private  long id;
    private final String title;
    private final String author;
    private final int yearsOfPublic;
    private final int numberOfPag;




    Book(int totalBook, long id, String title, String author, int yearsOfPublic, int numberOfPag) {
        this.TotalBook = totalBook;
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearsOfPublic = yearsOfPublic;
        this.numberOfPag = numberOfPag;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getTotalBook() {
        return TotalBook;
    }
    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearsOfPublic() {
        return yearsOfPublic;
    }

    public int getNumberOfPag() {
        return numberOfPag;
    }

    public void setTotalBook(int totalBook) {
        TotalBook = totalBook;
    }

    @Override
    public String toString() {
        return  "("+TotalBook+")  "+ title + "  (Author) " + author ;
    }

    public String toString2() {
        return "<html> " + " Id: " + id + "<br/>" + "Title: " + title + "<br/>" + " Author: " + author + "<br/>" + "Years of public: " + yearsOfPublic + "<br/>" + "Num of pag: " + numberOfPag + "<br/>" + "____________________" + "<br/>";
    }

}
