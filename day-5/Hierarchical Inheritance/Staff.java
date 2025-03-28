class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayPersonalInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        System.out.println("Role: Teacher");
    }

    public void displayTeacherInfo() {
        super.displayPersonalInfo();
        displayRole();
        System.out.println("Subject: " + subject);
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Smith", 35, "Mathematics");
        teacher.displayTeacherInfo();
    }
}

class Student extends Person {
    String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        System.out.println("Role: Student");
    }

    public void displayStudentInfo() {
        super.displayPersonalInfo();
        displayRole();
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Student student = new Student("Alice", 16, "10th");
        student.displayStudentInfo();
    }
}

class Staff extends Person {
    String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        System.out.println("Role: Staff");
    }

    public void displayStaffInfo() {
        super.displayPersonalInfo();
        displayRole();
        System.out.println("Department: " + department);
    }

    public static void main(String[] args) {
        Staff staff = new Staff("Ms. Jones", 40, "Administration");
        staff.displayStaffInfo();
    }
}