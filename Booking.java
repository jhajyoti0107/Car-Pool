public class Booking {
    int booking_id;
    Ride ride;
    User user;
    int seats_booked;
    double total_fare;

    public Booking(int booking_id, Ride ride, User user, int seats_booked) {
        this.booking_id = booking_id;
        this.ride = ride;
        this.user = user;
        this.seats_booked = seats_booked;
        this.total_fare = seats_booked * ride.fare;
    }

    public void showBookingDetails() {
        System.out.println("Booking ID: " + booking_id);
        System.out.println("Passenger: " + user.getName());
        System.out.println("Route: " + ride.source + " -> " + ride.destination);
        System.out.println("Seats: " + seats_booked);
        System.out.println("Total Fare: ₹" + total_fare);
        System.out.println("--------------------------------");
    }
}