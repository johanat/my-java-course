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

            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void insertData(String sqlQuery) {
        try {
            st = connection.createStatement();
            st.execute(sqlQuery);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM user");
            while (rs.next()) {

                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String dni = rs.getString("dni");
                String direction = rs.getString("direction");

                User user = new User(name, surname, dni, direction);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ArrayList<Borrowing> getBorrowings() {
        ArrayList<Borrowing> borrowings = new ArrayList<>();
        ArrayList<Integer> bookIds = new ArrayList<>();
        ArrayList<String> userIds = new ArrayList<>();
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM borrowing");
            while (rs.next()) {
                int id_borrowing = rs.getInt("id_borrowing");
                int book_id = rs.getInt("book_id");
                String dni = rs.getString("dni");
                String borrowing_date_str = rs.getString("borrowing_date");
                LocalDate borrowing_date = LocalDate.parse(borrowing_date_str);
                String returned_date_str = rs.getString("returned_date");
                LocalDate returned_date = LocalDate.parse(returned_date_str);

                userIds.add(dni);
                bookIds.add(book_id);

                Borrowing borrowing = new Borrowing(id_borrowing, null, null, borrowing_date, returned_date);
                borrowings.add(borrowing);
            }

            for (int i = 0; i < borrowings.size(); i++) {
                borrowings.get(i).book = getBook(bookIds.get(i));
                borrowings.get(i).user = getUser(userIds.get(i));
            }

            return borrowings;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Book getBook(int id) {
        Book book = null;
        try {
            String mySqlQuery = "SELECT * FROM book where id_book=" + id;
            ResultSet rs = st.executeQuery(mySqlQuery);
            while (rs.next()) {

                int id_book = rs.getInt("id_book");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int year_of_publish = rs.getInt("year_of_publish");
                int num_pages = rs.getInt("num_pages");
                int num_copies = rs.getInt("num_copies");

                book = new Book(num_copies, id_book, title, author, year_of_publish, num_pages);
            }
            return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    User getUser(String dniUser) {
        User user = null;
        try {
            String mySqlQuery = "SELECT * FROM user where dni =" + "'"+dniUser+"'";

            ResultSet rs = st.executeQuery(mySqlQuery);
            while (rs.next()) {


                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String dni = rs.getString("dni");
                String direction = rs.getString("direction");


                user = new User(name, surname, dni, direction);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ArrayList<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();

        try {
            st = connection.createStatement();
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

    void deleteBook(Book book) {
        try {
            st = connection.createStatement();
            st.execute("DELETE FROM book WHERE id_book = " + (int) book.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void deleteUser(User user) {
        System.out.println(user);
        try {
            st = connection.createStatement();
            String sql = "DELETE FROM user WHERE dni = " + "'" + user.getDNI() + "'";
            st.execute(sql);

            System.out.println(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void deleteBorrowing(Borrowing borrowing) {
        System.out.println(borrowing);
        try {
            st = connection.createStatement();
            st.execute("DELETE FROM borrowing WHERE id_borrowing = " + borrowing.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ArrayList<User> getBookUsers ( int  dni1){
        ArrayList<User> users = new ArrayList<>();

        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery("select user.name,user.dni from borrowing inner join user on borrowing.dni = user.dni where borrowing.book_id ="+dni1);
            while (rs.next()) {

                String name = rs.getString("name");
                String dni = rs.getString("dni");



                User user = new User(name,null,dni,null);
                users.add(user);
            }

            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        ArrayList<Book> getUserBook(String dni) {
            ArrayList<Book> books = new ArrayList<>();

            try {
                st = connection.createStatement();
                ResultSet rs = st.executeQuery("select Book.num_copies,Book.title,Book.author from borrowing inner join " +
                        "book on borrowing.book_id=book.id_book where borrowing.dni =" + "'" + dni + "'");
                while (rs.next()) {
                    int num_copies = rs.getInt("num_copies");
                    String title = rs.getString("title");
                    String author = rs.getString("author");

                    Book book = new Book(num_copies, -1, title, author, -1, -1);
                    books.add(book);
                }

                return books;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
            void updateBooksTotal(int num_copiesBook,int id){
                ArrayList<Book> updateBooks = new ArrayList<>();
                try {
                    st = connection.createStatement();
                    st.execute(" update book set num_copies ="+num_copiesBook+" where id_book="+id);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
}

