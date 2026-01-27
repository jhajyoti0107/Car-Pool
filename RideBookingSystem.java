public class RideBookingSystem {

    private static int bookingCounter = 1;

    // Add user (Registration)
    public void addUser(User user) {
        DataStore.users.add(user);
        System.out.println(" User " + user.getName());
    }

    // Add ride (Driver posts ride)
    public void addRide(Ride ride) {
        DataStore.rides.add(ride);
        System.out.println(" Ride added from " + ride.source + " to " + ride.destination);
    }

    // Show all available rides
    public void showAvailableRides() {
        System.out.println("\n Available Rides:");
        for (Ride r : DataStore.rides) {
            if (r.available_seats > 0) {
                System.out.println(
                        "Ride ID: " + r.id +
                                " | " + r.source + " -> " + r.destination +
                                " | Seats Left: " + r.available_seats +
                                " | Fare: ₹" + r.fare
                );
            }
        }
        System.out.println("--");
    }

    // Book ride
    public void bookRide(int rideId, User user, int seats) {

        for (Ride r : DataStore.rides) {
            if (r.id == rideId) {

                if (seats <= 0) {
                    System.out.println(" Invalid seat count");
                    return;
                }

                if (r.bookSeats(seats)) {

                    Booking booking = new Booking(
                            bookingCounter++,
                            r,
                            user,
                            seats
                    );

                    DataStore.bookings.add(booking);

                    System.out.println("🎉 Booking Successful!");
                    booking.showBookingDetails();

                } else {
                    System.out.println(" Not enough seats available");
                }
                return;
            }
        }
        System.out.println(" Ride not found");
    }

    public void showAllBookings() {
        System.out.println("\nBooking History:");
        for (Booking b : DataStore.bookings) {
            b.showBookingDetails();
        }
    }
}
