public class Ride {

    int rideId;
    String source;
    String destination;
    int seats;
    double price;

    public Ride(String source, String destination, int seats, double price) {
        this.source = source;
        this.destination = destination;
        this.seats = seats;
        this.price = price;
    }
}
