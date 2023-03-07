import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DbManager {
    private Connection connection;
    private Statement st;

    public void init() {
        connect();
        createTables();
    }

    private void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:library.db");

        } catch (Exception e) {

        }
    }

    private void createTables() {
        try {
            st = connection.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS book (\n" +
                    "  id_book INTEGER PRIMARY KEY,\n" +
                    "  title TEXT,\n" +
                    "  author TEXT,\n" +
                    "  year_of_publish INTEGER,\n" +
                    "  num_pages INTEGER,\n" +
                    "  num_copies INTEGER DEFAULT 2\n" +
                    ");");
            st.execute("CREATE TABLE IF NOT EXISTS user (\n" +
                    "  name TEXT,\n" +
                    "  surname TEXT,\n" +
                    "  dni TEXT PRIMARY KEY,\n" +
                    "  direction TEXT\n" +
                    ");");
            st.execute("CREATE TABLE IF NOT EXISTS borrowing (\n" +
                    "  id_borrowing INTEGER PRIMARY KEY,\n" +
                    "  book_id INTEGER,\n" +
                    "  dni TEXT,\n" +
                    "  borrowing_date TEXT,\n" +
                    "  returned_date TEXT\n" +
                    ");");

            //st.execute("INSERT INTO LOGIN(username,password)"+"values('1234', '1234')");
           // st.execute("INSERT INTO book (title, author, year_of_publish, num_pages)"+" VALUES ('Harry Potter', 'J.R Rowling', 1997, 2000)");
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void insertData(String sqlQuery){
        try {
            st = connection.createStatement();
            st.execute(sqlQuery);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM user");
            while (rs.next()) {

                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String dni = rs.getString("dni");
                String direction= rs.getString("direction");


                User user = new User(name, surname,dni,direction);
                users.add(user);
            }
        return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    ArrayList<Borrowing> getBorrowing(){
        ArrayList<Borrowing> borrowings = new ArrayList<>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM borrowing");
            while (rs.next()) {

                int id_borrowing = rs.getInt("id_borrowing");

                int book_id = rs.getInt("book_id");
                Book book=(getBook(book_id));

                String dni = rs.getString("dni");
                User user =(getUser(dni));

                String borrowing_date_str = rs.getString("borrowing_date");
                LocalDate borrowing_date = LocalDate.parse(borrowing_date_str);

                String returned_date_str = rs.getString("returned_date");
                LocalDate returned_date = LocalDate.parse(returned_date_str);


                Borrowing borrowing = new Borrowing(book, user, borrowing_date, returned_date);
                borrowings.add(borrowing);
            }
            return borrowings;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    Book getBook(int id){
        Book book = null;
        try {
            String mySqlQuery = "SELECT * FROM book where id_book="+id;
           // System.out.println("My query >>> " + mySqlQuery);
            ResultSet rs = st.executeQuery(mySqlQuery);
            while (rs.next()) {

                int id_book = rs.getInt("id_book");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int year_of_publish = rs.getInt("year_of_publish");
                int num_pages = rs.getInt("num_pages");
                int num_copies = rs.getInt("num_copies");

                 new Book(num_copies, id_book, title, author, year_of_publish, num_pages);
            }
            return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    User getUser(String dniUser){
       User user = null;
        try {
            String mySqlQuery = "SELECT * FROM user where dniUser ="+dniUser;

            ResultSet rs = st.executeQuery(mySqlQuery);
            while (rs.next()) {


                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String dni = rs.getString("dniUser");
                String direction = rs.getString("direction");


                new User(name, surname, dni, direction);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ArrayList<Book> getBooks(){
        ArrayList<Book> books = new ArrayList<>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM book");
            while (rs.next()) {

                int id_book = rs.getInt("id_book");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int year_of_publish = rs.getInt("year_of_publish");
                int num_pages = rs.getInt("num_pages");
                int num_copies = rs.getInt("num_copies");

                Book book = new Book(num_copies, id_book, title, author, year_of_publish, num_pages);
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
