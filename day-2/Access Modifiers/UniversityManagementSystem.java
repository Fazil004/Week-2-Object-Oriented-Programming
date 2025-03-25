class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to access CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to modify CGPA
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public void displayStudentInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    String specialization;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    public void displayPostgraduateInfo() {
        System.out.println("--- Postgraduate Student Info ---");
        System.out.println("Roll Number (Public): " + rollNumber);
        System.out.println("Name (Protected - Accessible in subclass): " + name);
        System.out.println("CGPA (Private - Accessible via public method): " + getCGPA());
        System.out.println("Specialization: " + specialization);
    }

    // Example of accessing protected member
    public String getStudentName() {
        return this.name; // Accessing the protected 'name' member
    }

    // Example of modifying private member using public method
    public void updateCGPA(double newCGPA) {
        setCGPA(newCGPA); // Using the public setter method for 'CGPA'
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student undergraduateStudent = new Student(101, "Alice", 8.5);
        System.out.println("--- Undergraduate Student Info ---");
        System.out.println("Roll Number (Public): " + undergraduateStudent.rollNumber);
        System.out.println("Name (Protected - Not directly accessible here): " + undergraduateStudent.name);
        System.out.println("CGPA (Private - Accessible via public method): " + undergraduateStudent.getCGPA());

        // Accessing and modifying CGPA using public methods
        undergraduateStudent.setCGPA(8.8);
        System.out.println("Updated CGPA: " + undergraduateStudent.getCGPA());

        PostgraduateStudent postgraduateStudent = new PostgraduateStudent(201, "Bob", 9.2, "Computer Science");
        postgraduateStudent.displayPostgraduateInfo();

        // Accessing protected member from subclass
        System.out.println("Postgraduate Student Name (via subclass method): " + postgraduateStudent.getStudentName());

        // Modifying private member from subclass using public method
        postgraduateStudent.updateCGPA(9.5);
        System.out.println("Updated Postgraduate CGPA: " + postgraduateStudent.getCGPA());
    }
}