class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
            System.out.println("Salary updated to ₹" + this.salary);
        } else {
            System.out.println("Invalid salary value.");
        }
    }

    // Public method to access salary
    public double getSalary() {
        return salary;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID (Public): " + employeeID);
        System.out.println("Department (Protected): " + department);
        System.out.println("Salary (Private - Accessible via public method): ₹" + getSalary());
    }
}

class Manager extends Employee {
    private String teamLead;

    public Manager(int employeeID, String department, double salary, String teamLead) {
        super(employeeID, department, salary);
        this.teamLead = teamLead;
    }

    public void displayManagerInfo() {
        System.out.println("--- Manager Info ---");
        System.out.println("Employee ID (Public - Accessible in subclass): " + employeeID);
        System.out.println("Department (Protected - Accessible in subclass): " + department);
        System.out.println("Salary (Private - Accessible via superclass method): ₹" + getSalary());
        System.out.println("Team Lead: " + teamLead);
    }

    // Example of accessing protected member
    public String getDepartmentName() {
        return this.department; // Accessing the protected 'department' member
    }

    // Example of modifying private member using public method
    public void updateSalary(double newSalary) {
        setSalary(newSalary); // Using the public setter method for 'salary'
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Employee regularEmployee = new Employee(1001, "Development", 60000.00);
        System.out.println("--- Regular Employee Info ---");
        System.out.println("Employee ID (Public): " + regularEmployee.employeeID);
        System.out.println("Department (Protected - Not directly accessible here): " + regularEmployee.department);
        System.out.println("Salary (Private - Accessible via public method): ₹" + regularEmployee.getSalary());

        // Modifying salary using the public method
        regularEmployee.setSalary(65000.00);

        Manager manager = new Manager(2001, "Marketing", 80000.00, "Priya Sharma");
        manager.displayManagerInfo();

        // Accessing public and protected members from subclass
        System.out.println("Manager Employee ID (via subclass): " + manager.employeeID);
        System.out.println("Manager Department (via subclass method): " + manager.getDepartmentName());

        // Modifying private salary from subclass using public method
        manager.updateSalary(85000.00);
        System.out.println("Current Manager Salary: ₹" + manager.getSalary());
    }
}