class Vehicle {
    public static double registrationFee;
    public final int registrationNumber;
    public String ownerName;
    public String vehicleType;

    static{
        registrationFee = 500.0;
    }
    public Vehicle(int registrationNumber, String ownerName, String vehicleType) {//creating constructor
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public void displayDetails() {
        System.out.println("Registration No: " + registrationNumber);
        System.out.println("Owner: " + ownerName);
        System.out.println("Type: " + vehicleType);
        System.out.println("Registration Fee: Rs." + registrationFee);
    }
}

public class VehicleSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(1010, "Kiran", "Car");
        Vehicle v2 = new Vehicle(1020, "Manoj", "Bike");

        if (v1 instanceof Vehicle) v1.displayDetails();
        if (v2 instanceof Vehicle) v2.displayDetails(); //checking if the object is instance of the class

        Vehicle.updateRegistrationFee(600.0);
        System.out.println("\nUpdated Fee:");
        v1.displayDetails();
    }
}