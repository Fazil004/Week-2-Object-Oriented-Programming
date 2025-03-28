class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: ₹" + String.format("%.2f", salary));
    }
}

class Manager extends Employee {
    int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    int stipend;

    public Intern(String name, int id, int stipend) {
        super(name, id, 0); // Interns might not have a base salary
        this.stipend = stipend;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Stipend: ₹" + String.format("%.2f", stipend));
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Manager manager = new Manager("Alice", 101, 80000.00, 10);
        Developer developer = new Developer("Bob", 201, 60000.00, "Java");
        Intern intern = new Intern("Charlie", 301, 15000);

        System.out.println("--- Manager Details ---");
        manager.displayDetails();

        System.out.println("\n--- Developer Details ---");
        developer.displayDetails();

        System.out.println("\n--- Intern Details ---");
        intern.displayDetails();

        Employee[] employees = {manager, developer, intern};
        System.out.println("\n--- All Employees ---");
        for (Employee emp : employees) {
            emp.displayDetails(); // Polymorphism
            System.out.println("---");
        }
    }
}