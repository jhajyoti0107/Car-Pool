public class Ride {
    int id;
    String source;
    String destination;
    int total_seats;
    int available_seats;
    double fare;
    User user; // driver

    public Ride(int id, String source, String destination, int total_seats, double fare, User user) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.total_seats = total_seats;
        this.available_seats = total_seats;
        this.fare = fare;
        this.user = user;
    }

    public boolean bookSeats(int seats) {
        if (seats <= available_seats) {
            available_seats -= seats;
            return true;
        }
        return false;
    }
}