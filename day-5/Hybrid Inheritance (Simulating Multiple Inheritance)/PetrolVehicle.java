class Vehicle {
    int maxSpeed;
    String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public void displayVehicleInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    int batteryCapacityKWh;

    public ElectricVehicle(int maxSpeed, String model, int batteryCapacityKWh) {
        super(maxSpeed, model);
        this.batteryCapacityKWh = batteryCapacityKWh;
    }

    public void charge() {
        System.out.println(model + " is charging.");
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Battery Capacity: " + batteryCapacityKWh + " kWh");
        charge();
    }

    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(200, "Tesla Model S", 100);
        ev.displayVehicleInfo();
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelTankCapacityLiters;

    public PetrolVehicle(int maxSpeed, String model, int fuelTankCapacityLiters) {
        super(maxSpeed, model);
        this.fuelTankCapacityLiters = fuelTankCapacityLiters;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling.");
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacityLiters + " liters");
        refuel();
    }

    public static void main(String[] args) {
        PetrolVehicle pv = new PetrolVehicle(180, "Toyota Camry", 60);
        pv.displayVehicleInfo();
    }
}