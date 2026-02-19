import java.sql.*;

public class BookingDAO {

    public void bookRide(int rideId, int passengerId, int seats) {

        try (Connection conn = DBConnection.getConnection()) {

            // Check seats
            String checkSql = "SELECT available_seats FROM rides WHERE ride_id = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setInt(1, rideId);
            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {

                int available = rs.getInt("available_seats");

                if (available < seats) {
                    System.out.println("❌ Not enough seats available!");
                    return;
                }

                // Insert booking
                String insertSql = "INSERT INTO bookings(ride_id, passenger_id, seats_booked) VALUES (?, ?, ?)";
                PreparedStatement insertPs = conn.prepareStatement(insertSql);
                insertPs.setInt(1, rideId);
                insertPs.setInt(2, passengerId);
                insertPs.setInt(3, seats);
                insertPs.executeUpdate();

                // Update seats
                String updateSql = "UPDATE rides SET available_seats = available_seats - ? WHERE ride_id = ?";
                PreparedStatement updatePs = conn.prepareStatement(updateSql);
                updatePs.setInt(1, seats);
                updatePs.setInt(2, rideId);
                updatePs.executeUpdate();

                System.out.println("✅ Ride Booked Successfully");

            } else {
                System.out.println("❌ Ride not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
