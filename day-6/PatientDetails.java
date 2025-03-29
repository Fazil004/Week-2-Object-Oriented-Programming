import java.util.ArrayList;
import java.util.List;

// Abstract class Patient
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
    }
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

// Class InPatient
class InPatient extends Patient implements MedicalRecord {
    private int roomNumber;
    private int daysAdmitted;
    private String diagnosis; // Encapsulated
    private List<String> medicalHistory; // Encapsulated

    public InPatient(int patientId, String name, int age, int roomNumber, int daysAdmitted, String diagnosis) {
        super(patientId, name, age);
        this.roomNumber = roomNumber;
        this.daysAdmitted = daysAdmitted;
        this.diagnosis = diagnosis;
        this.medicalHistory = new ArrayList<>();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getDaysAdmitted() {
        return daysAdmitted;
    }

    // Getter for diagnosis
    private String getDiagnosis(){
        return diagnosis;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * 1000 + 5000; // Example: 1000 per day + 5000 fixed cost
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalHistory;
    }

    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Days Admitted: " + daysAdmitted + " days");
        System.out.println("Diagnosis: " + getDiagnosis());
        System.out.println("Bill: ₹" + String.format("%.2f", calculateBill()));
    }
}

// Class OutPatient
class OutPatient extends Patient implements MedicalRecord {
    private String visitReason;
    private String prescription; // Encapsulated
    private List<String> medicalHistory; // Encapsulated

    public OutPatient(int patientId, String name, int age, String visitReason, String prescription) {
        super(patientId, name, age);
        this.visitReason = visitReason;
        this.prescription = prescription;
        this.medicalHistory = new ArrayList<>();
    }

    public String getVisitReason() {
        return visitReason;
    }

    //getter for prescription
    private String getPrescription(){
        return prescription;
    }

    @Override
    public double calculateBill() {
        return 500; // Fixed consultation fee
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalHistory;
    }

     @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Visit Reason: " + visitReason);
        System.out.println("Prescription: " + getPrescription());
        System.out.println("Bill: ₹" + String.format("%.2f", calculateBill()));
    }
}

// Main class
public class PatientDetails {
    public static void main(String[] args) {
        // Create patients
        InPatient inPatient1 = new InPatient(101, "John Doe", 45, 201, 5, "Pneumonia");
        OutPatient outPatient1 = new OutPatient(201, "Jane Smith", 30, "Checkup", "Amoxicillin 500mg");

        // Add medical records
        inPatient1.addRecord("Admitted on 2024-07-20");
        inPatient1.addRecord("Started on antibiotics");
        outPatient1.addRecord("Follow-up appointment in 2 weeks");
        outPatient1.addRecord("Prescribed pain reliever");

        List<Patient> patients = new ArrayList<>();
        patients.add(inPatient1);
        patients.add(outPatient1);

        // Display patient details and medical records
        System.out.println("\n--- Patient Details ---");
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("\n--- Medical Records for " + patient.getName() + " ---");
            for (String record : ((MedicalRecord) patient).viewRecords()) {
                System.out.println(record);
            }
            System.out.println("----------------------");
        }
    }
}