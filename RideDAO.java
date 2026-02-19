import java.sql.*;

public class RideDAO {

    public void createRide(int driverId, String source, String destination, int seats, double price) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "INSERT INTO rides(driver_id, source, destination, available_seats, price) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, driverId);
            ps.setString(2, source);
            ps.setString(3, destination);
            ps.setInt(4, seats);
            ps.setDouble(5, price);

            ps.executeUpdate();

            System.out.println("✅ Ride Created Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewRides() {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT * FROM rides";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        "Ride ID: " + rs.getInt("ride_id") +
                                " | Source: " + rs.getString("source") +
                                " | Destination: " + rs.getString("destination") +
                                " | Seats: " + rs.getInt("available_seats") +
                                " | Price: " + rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
