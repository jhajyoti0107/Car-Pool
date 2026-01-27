public class Main {
    public static void main(String[] args) {

        RideBookingSystem system = new RideBookingSystem();

        // Users
        User driver = new User(1, "Jyoti", "2024876440.jyoti@ug.sharda.ac.in", "1234");
        User passenger = new User(2, "jaya", "jaya122@gmail.com", "abcd");

        system.addUser(driver);
        system.addUser(passenger);


        Ride ride1 = new Ride(195, "Delhi", "Noida", 4, 150, driver);
        system.addRide(ride1);
        system.showAvailableRides();
        system.bookRide(195, passenger, 3);
        system.showAllBookings();
    }
}