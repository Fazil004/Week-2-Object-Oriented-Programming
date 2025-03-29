import java.util.ArrayList;
import java.util.List;

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per KM: ₹" + String.format("%.2f", ratePerKm));
    }
}

// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Class Car
class Car extends Vehicle implements GPS {
    private String carType; // e.g., "Sedan", "SUV"
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm, String carType) {
        super(vehicleId, driverName, ratePerKm);
        this.carType = carType;
        this.currentLocation = "Unknown";
    }

    public String getCarType() {
        return carType;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Car " + getVehicleId() + " location updated to " + currentLocation);
    }

    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Car Type: " + carType);
        System.out.println("Current Location: " + getCurrentLocation());
    }
}

// Class Bike
class Bike extends Vehicle implements GPS {
    private String bikeType; // e.g., "Regular", "Sports"
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm, String bikeType) {
        super(vehicleId, driverName, ratePerKm);
        this.bikeType = bikeType;
        this.currentLocation = "Unknown";
    }

    public String getBikeType() {
        return bikeType;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Bike " + getVehicleId() + " location updated to " + currentLocation);
    }

    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Bike Type: " + bikeType);
         System.out.println("Current Location: " + getCurrentLocation());
    }
}

// Class Auto
class Auto extends Vehicle implements GPS {
    private String autoType;  //e.g, "Regular", "Share"
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm, String autoType) {
        super(vehicleId, driverName, ratePerKm);
        this.autoType = autoType;
        this.currentLocation = "Unknown";
    }

     public String getAutoType() {
        return autoType;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Auto " + getVehicleId() + " location updated to " + currentLocation);
    }

    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Auto Type: " + autoType);
        System.out.println("Current Location: " + getCurrentLocation());
    }
}

// Class to manage bookings and calculate fares
class BookingManager {
    // Method to calculate fares for a list of vehicles
    public void calculateAndDisplayFares(List<Vehicle> vehicles, double distance) {
        System.out.println("\n--- Fare Calculation for Distance: " + distance + " km ---");
        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            double fare = vehicle.calculateFare(distance);
            System.out.println("Fare: ₹" + String.format("%.2f", fare));
            System.out.println("----------------------");
        }
    }
}

// Main class
public class VehicleInfo {
    public static void main(String[] args) {
        // Create vehicles
        Car car1 = new Car("CAR123", "Alice", 15.0, "Sedan");
        Bike bike1 = new Bike("BIKE456", "Bob", 8.0, "Regular");
        Auto auto1 = new Auto("AUTO789", "Charlie", 10.0, "Share");

        // Update locations
        car1.updateLocation("Kolkata");
        bike1.updateLocation("Mumbai");
        auto1.updateLocation("Delhi");

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car1);
        vehicles.add(bike1);
        vehicles.add(auto1);

        // Create a BookingManager and calculate fares
        BookingManager bookingManager = new BookingManager();
        bookingManager.calculateAndDisplayFares(vehicles, 20.0);
    }
}