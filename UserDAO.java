public import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public static void addUser(User user) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO users(name, email) VALUES(?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 UserDAO {
    
}
