public class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 1000.00; // Class variable with a default value

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + String.format("%.2f", registrationFee));
    }

    // Class method to update the registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: ₹" + String.format("%.2f", registrationFee));
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Alice Sharma", "Car");
        Vehicle vehicle2 = new Vehicle("Bob Singh", "Motorcycle");
        Vehicle vehicle3 = new Vehicle("Charlie Verma", "Truck");

        System.out.println("--- Vehicle 1 Details ---");
        vehicle1.displayVehicleDetails();

        System.out.println("\n--- Vehicle 2 Details ---");
        vehicle2.displayVehicleDetails();

        System.out.println("\n--- Vehicle 3 Details ---");
        vehicle3.displayVehicleDetails();

        System.out.println("\n--- Update Registration Fee ---");
        Vehicle.updateRegistrationFee(1500.00); // Calling the class method

        System.out.println("\n--- Vehicle 1 Details (after fee update) ---");
        vehicle1.displayVehicleDetails();

        System.out.println("\n--- Vehicle 2 Details (after fee update) ---");
        vehicle2.displayVehicleDetails();

        System.out.println("\n--- Vehicle 3 Details (after fee update) ---");
        vehicle3.displayVehicleDetails();
    }
}