import java.util.ArrayList;
import java.util.List;

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate; // per day

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public void displayVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: ₹" + String.format("%.2f", rentalRate) + " per day");
    }
}

// Interface Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Class Car
class Car extends Vehicle implements Insurable {
    private int seatCapacity;
    private String insurancePolicyNumber; // Encapsulated

    public Car(String vehicleNumber, String type, double rentalRate, int seatCapacity, String insurancePolicyNumber) {
        super(vehicleNumber, type, rentalRate);
        this.seatCapacity = seatCapacity;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    // Getter for insurance policy number (for internal use within the class)
    private String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Comprehensive Insurance (Policy Number: " + getInsurancePolicyNumber() + ")";
    }

    @Override
    public void displayVehicleDetails() {
        super.displayVehicleDetails();
        System.out.println("Seat Capacity: " + seatCapacity);
        System.out.println("Insurance: ₹" + String.format("%.2f", calculateInsurance()) + " (" + getInsuranceDetails() + ")");
    }
}

// Class Bike
class Bike extends Vehicle implements Insurable {
    private String handleType;  // "Regular" or "Sports"
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, String type, double rentalRate, String handleType, String insurancePolicyNumber) {
        super(vehicleNumber, type, rentalRate);
        this.handleType = handleType;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getHandleType() {
        return handleType;
    }

     private String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10; // 10% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
         return "Basic Insurance (Policy Number: " + getInsurancePolicyNumber() + ")";
    }

    @Override
    public void displayVehicleDetails() {
        super.displayVehicleDetails();
        System.out.println("Handle Type: " + handleType);
        System.out.println("Insurance: ₹" + String.format("%.2f", calculateInsurance()) + " (" + getInsuranceDetails() + ")");
    }
}

// Class Truck
class Truck extends Vehicle implements Insurable {
    private double cargoCapacity; // in tons
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, String type, double rentalRate, double cargoCapacity, String insurancePolicyNumber) {
        super(vehicleNumber, type, rentalRate);
        this.cargoCapacity = cargoCapacity;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

     private String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }


    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + (cargoCapacity * 100); // Additional cost per ton
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.20; // 20% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Commercial Insurance (Policy Number: " + getInsurancePolicyNumber() + ")";
    }

    @Override
    public void displayVehicleDetails() {
        super.displayVehicleDetails();
        System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
        System.out.println("Insurance: ₹" + String.format("%.2f", calculateInsurance()) + " (" + getInsuranceDetails() + ")";
    }
}

// Main class
public class VehicleInsurance {
    public static void main(String[] args) {
        // Create vehicles
        Car car1 = new Car("CAR123", "Car", 2000.00, 5, "CAR-INS-001");
        Bike bike1 = new Bike("BIKE456", "Bike", 500.00, "Regular", "BIKE-INS-002");
        Truck truck1 = new Truck("TRUCK789", "Truck", 3000.00, 15.0, "TRUCK-INS-003");

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(car1);
        vehicleList.add(bike1);
        vehicleList.add(truck1);

        int rentalDays = 7;

        System.out.println("\n--- Vehicle Rental Information for " + rentalDays + " days ---");
        for (Vehicle vehicle : vehicleList) {
            vehicle.displayVehicleDetails();
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            System.out.println("Rental Cost: ₹" + String.format("%.2f", rentalCost));
            System.out.println("----------------------");
        }
    }
}