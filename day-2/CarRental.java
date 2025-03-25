public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate; // Added daily rate for cost calculation

    // Constructor
    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    // Constructor without daily rate (can set a default)
    public CarRental(String customerName, String carModel, int rentalDays) {
        this(customerName, carModel, rentalDays, 500.0); // Default daily rate of 500
    }

    // Default constructor
    public CarRental() {
        this("Guest", "Sedan", 1, 500.0);
    }

    // Copy constructor
    public CarRental(CarRental otherRental) {
        this.customerName = otherRental.customerName;
        this.carModel = otherRental.carModel;
        this.rentalDays = otherRental.rentalDays;
        this.dailyRate = otherRental.dailyRate;
    }

    public double calculateTotalCost() {
        return dailyRate * rentalDays;
    }

    public void displayRentalInfo() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: ₹" + String.format("%.2f", dailyRate));
        System.out.println("Total Cost: ₹" + String.format("%.2f", calculateTotalCost()));
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental();
        System.out.println("Rental 1 (Default):");
        rental1.displayRentalInfo();

        CarRental rental2 = new CarRental("Eve", "SUV", 5, 1200.0);
        System.out.println("\nRental 2 (Parameterized):");
        rental2.displayRentalInfo();

        CarRental rental3 = new CarRental("Frank", "Hatchback", 2); // Using constructor without daily rate
        System.out.println("\nRental 3 (Parameterized - default rate):");
        rental3.displayRentalInfo();

        CarRental rental4 = new CarRental(rental2); // Copy constructor
        System.out.println("\nRental 4 (Copy of Rental 2):");
        rental4.displayRentalInfo();

        rental4.rentalDays = 7;
        System.out.println("\nRental 4 (After modification):");
        rental4.displayRentalInfo();
        System.out.println("\nRental 2 (Unchanged):");
        rental2.displayRentalInfo();
    }
}