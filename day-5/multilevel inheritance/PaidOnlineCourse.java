class Course {
    String courseName;
    String duration;

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration);
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    public OnlineCourse(String courseName, String duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    public PaidOnlineCourse(String courseName, String duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double getFinalFee() {
        return fee * (1 - discount / 100);
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Fee: ₹" + String.format("%.2f", fee));
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee: ₹" + String.format("%.2f", getFinalFee()));
    }

    public static void main(String[] args) {
        Course basicCourse = new Course("Introduction to Programming", "2 weeks");
        OnlineCourse freeCourse = new OnlineCourse("Python Basics", "4 weeks", "Coursera", true);
        PaidOnlineCourse premiumCourse = new PaidOnlineCourse("Advanced Java", "6 weeks", "Udemy", true, 4999.00, 15.0);

        System.out.println("--- Basic Course ---");
        basicCourse.displayCourseInfo();

        System.out.println("\n--- Free Online Course ---");
        freeCourse.displayCourseInfo();

        System.out.println("\n--- Premium Paid Online Course ---");
        premiumCourse.displayCourseInfo();
    }
}