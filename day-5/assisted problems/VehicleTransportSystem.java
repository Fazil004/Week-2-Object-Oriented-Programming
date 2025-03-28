class Vehicle {
    int maxSpeed;
    String fuelType;

    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle {
    int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    double cargoCapacityTons;

    public Truck(int maxSpeed, String fuelType, double cargoCapacityTons) {
        super(maxSpeed, fuelType);
        this.cargoCapacityTons = cargoCapacityTons;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Cargo Capacity: " + cargoCapacityTons + " tons");
    }
}

class Motorcycle extends Vehicle {
    boolean hasSidecar;

    public Motorcycle(int maxSpeed, String fuelType, boolean hasSidecar) {
        super(maxSpeed, fuelType);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + hasSidecar);
    }
}

public class VehicleTransportSystem {
    public static void main(String[] args) {
        Car myCar = new Car(180, "Petrol", 5);
        Truck myTruck = new Truck(120, "Diesel", 10.5);
        Motorcycle myMotorcycle = new Motorcycle(150, "Petrol", false);

        System.out.println("--- Car Info ---");
        myCar.displayInfo();

        System.out.println("\n--- Truck Info ---");
        myTruck.displayInfo();

        System.out.println("\n--- Motorcycle Info ---");
        myMotorcycle.displayInfo();

        Vehicle[] vehicles = {myCar, myTruck, myMotorcycle};
        System.out.println("\n--- All Vehicles ---");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo(); // Polymorphism
            System.out.println("---");
        }
    }
}