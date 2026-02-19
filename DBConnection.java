import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/ride_app";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Jyoti";  // change this

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL Driver not found!");
            throw new SQLException(e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
