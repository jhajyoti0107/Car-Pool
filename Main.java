import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RideDAO rideDAO = new RideDAO();
        BookingDAO bookingDAO = new BookingDAO();

        while (true) {

            System.out.println("1. Create Ride");
            System.out.println("2. View Rides");
            System.out.println("3. Book Ride");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter Driver ID:");
                    int driverId = sc.nextInt();

                    System.out.println("Enter Source:");
                    String source = sc.next();

                    System.out.println("Enter Destination:");
                    String destination = sc.next();

                    System.out.println("Enter Seats:");
                    int seats = sc.nextInt();

                    System.out.println("Enter Price:");
                    double price = sc.nextDouble();

                    rideDAO.createRide(driverId, source, destination, seats, price);

                    break;

                case 2:
                    rideDAO.viewRides();
                    break;

                case 3:
                    System.out.println("Enter Ride ID:");
                    int rideId = sc.nextInt();

                    System.out.println("Enter Passenger ID:");
                    int passengerId = sc.nextInt();

                    System.out.println("Enter Seats:");
                    int bookSeats = sc.nextInt();

                    bookingDAO.bookRide(rideId, passengerId, bookSeats);

                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}
