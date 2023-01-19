public class Book {
    private String title;
    private String author;
    private int yearsOfPublic;
    private int numberOfPag;

    Book(String title, String author, int yearsOfPublic, int numberOfPag) {
        this.title = title;
        this.author = author;
        this.yearsOfPublic = yearsOfPublic;
        this.numberOfPag = numberOfPag;
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

    @Override
    public String toString() {
        return "<html> "+"Title: "+title+ "<br/>"+ " Author: "+author+ "<br/>"+"Years of public: "+yearsOfPublic+"<br/>"+ "Num of pag: "+numberOfPag+"<br/>"+"___________"+"<br/>";
    }
}
