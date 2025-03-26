class Patient {
    public static String hospitalName;
    private static int totalPatients;
    static {
        hospitalName = "Gevernova Hospital";
        totalPatients = 0;
    }

    public final int patientID;
    public String name;
    public int age;
    public String ailment;

    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    public void displayDetails() {
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Hospital: " + hospitalName);
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient(201, "Ravi", 45, "Fever");
        Patient p2 = new Patient(202, "Sara", 30, "Cold");

        if (p1 instanceof Patient) p1.displayDetails();
        if (p2 instanceof Patient) p2.displayDetails();

        Patient.getTotalPatients();
    }
}