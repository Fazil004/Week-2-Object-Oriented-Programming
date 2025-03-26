class Student {
    public static String universityName;
    private static int totalStudents;
    public final int rollNumber;
    public String name;
    public String grade;
    static {
        universityName = " University of Hyderabad";
        totalStudents = 0;
    }

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayDetails() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("University: " + universityName);
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        Student s1 = new Student(1, "John", "A");
        Student s2 = new Student(2, "Jane", "B");

        if (s1 instanceof Student) s1.displayDetails();
        if (s2 instanceof Student) s2.displayDetails();

        Student.displayTotalStudents();
    }
}