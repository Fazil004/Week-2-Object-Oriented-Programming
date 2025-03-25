public class Course {
    String courseName;
    String duration;
    double fee;
    static String instituteName = "Tech Institute"; // Class variable with a default value

    // Constructor
    public Course(String courseName, String duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration);
        System.out.println("Fee: ₹" + String.format("%.2f", fee));
        System.out.println("Institute: " + instituteName);
    }

    // Class method to update the institute name
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
        System.out.println("Institute name updated to: " + instituteName);
    }

    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", "3 months", 15000.00);
        Course course2 = new Course("Web Development", "6 months", 25000.00);
        Course course3 = new Course("Data Science", "4 months", 20000.00);

        System.out.println("--- Course 1 Details ---");
        course1.displayCourseDetails();

        System.out.println("\n--- Course 2 Details ---");
        course2.displayCourseDetails();

        System.out.println("\n--- Course 3 Details ---");
        course3.displayCourseDetails();

        System.out.println("\n--- Update Institute Name ---");
        Course.updateInstituteName("Global Learning Center"); // Calling the class method

        System.out.println("\n--- Course 1 Details (after update) ---");
        course1.displayCourseDetails();

        System.out.println("\n--- Course 2 Details (after update) ---");
        course2.displayCourseDetails();

        System.out.println("\n--- Course 3 Details (after update) ---");
        course3.displayCourseDetails();
    }
}