public class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    // Default constructor
    public HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    public HotelBooking(HotelBooking otherBooking) {
        this.guestName = otherBooking.guestName;
        this.roomType = otherBooking.roomType;
        this.nights = otherBooking.nights;
    }

    public void displayBookingInfo() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }

    public static void main(String[] args) {
        HotelBooking booking1 = new HotelBooking();
        System.out.println("Booking 1 (Default):");
        booking1.displayBookingInfo();

        HotelBooking booking2 = new HotelBooking("Charlie", "Deluxe", 3);
        System.out.println("\nBooking 2 (Parameterized):");
        booking2.displayBookingInfo();

        HotelBooking booking3 = new HotelBooking(booking2); // Copy constructor
        System.out.println("\nBooking 3 (Copy of Booking 2):");
        booking3.displayBookingInfo();

        booking3.guestName = "David";
        booking3.nights = 2;
        System.out.println("\nBooking 3 (After modification):");
        booking3.displayBookingInfo();
        System.out.println("\nBooking 2 (Unchanged):");
        booking2.displayBookingInfo();
    }
}