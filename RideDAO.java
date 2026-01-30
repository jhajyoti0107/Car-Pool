import java.sql.Connection;
import java.sql.PreparedStatement;

public class RideDAO {

    public static void addRide(Ride ride) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO rides(source, destination, seats, fare) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ride.source);
            ps.setString(2, ride.destination);
            ps.setInt(3, ride.seats);
            ps.setDouble(4, ride.fare);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

