import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookingDAO {

    public static void addBooking(Booking booking) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO bookings(user_id, ride_id, seats_booked, total_fare) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, booking.user.getUserId());
            ps.setInt(2, booking.ride.ride_id);
            ps.setInt(3, booking.seats_booked);
            ps.setDouble(4, booking.total_fare);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
