import java.util.Scanner;

class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked;

    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = null;
        this.price = 0.0;
        this.isBooked = false;
    }

    public void bookTicket(String seat) {
        if (!isBooked) {
            this.seatNumber = seat;
            if (seat.startsWith("A")) {
                this.price = 150.0;
            } else if (seat.startsWith("B")) {
                this.price = 120.0;
            } else {
                this.price = 100.0;
            }
            this.isBooked = true;
            System.out.println("Ticket booked for " + movieName + " on seat " + seat + " for ₹" + price);
        } else {
            System.out.println("Ticket for " + movieName + " (seat " + seatNumber + ") is already booked.");
        }
    }

    public void displayDetails() {
        if (isBooked) {
            System.out.println("--- Ticket Details ---");
            System.out.println("Movie: " + movieName);
            System.out.println("Seat: " + seatNumber);
            System.out.println("Price: ₹" + price);
            System.out.println("----------------------");
        } else {
            System.out.println("No ticket booked for " + movieName + " yet.");
        }
    }
}

public class MovieBookingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Movie Booking System!");

        MovieTicket currentTicket = new MovieTicket("Avatar 2");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter seat number to book: ");
                    String seatToBook = scanner.nextLine().toUpperCase();
                    currentTicket.bookTicket(seatToBook);
                    break;
                case 2:
                    currentTicket.displayDetails();
                    break;
                case 3:
                    System.out.println("Thank you for using the booking system!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}