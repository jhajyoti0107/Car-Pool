public class RideBookingSystem2 {

    public void registerUser(User user) {
        UserDAO.addUser(user);
        System.out.println("User registered successfully");
    }

    public void addRide(Ride ride) {
        RideDAO.addRide(ride);
        System.out.println("Ride added successfully");
    }

    public void bookRide(Booking booking) {
        BookingDAO.addBooking(booking);
        System.out.println("Ride booked successfully");
    }
}
