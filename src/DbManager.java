import java.sql.*;

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
            st.execute("CREATE TABLE IF NOT EXISTS login(id INTEGER, username VARCHAR, password VARCHAR)");
            st.execute("INSERT INTO LOGIN(username,password)"+"values('1234', '1234')");
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeQuery() {
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM LOGIN WHERE username = '1234' AND password = '1234'");
            while (rs.next()) {
                int id= rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(">>> id = " + id + ", username = "+username+", password = "+password);
            }
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
