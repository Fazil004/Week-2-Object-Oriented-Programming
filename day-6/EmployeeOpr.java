import java.util.ArrayList;
import java.util.List;

// Abstract class Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Concrete method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: ₹" + String.format("%.2f", baseSalary));
        System.out.println("Salary: ₹" + String.format("%.2f", calculateSalary()));
    }
}

// Subclass FullTimeEmployee
class FullTimeEmployee extends Employee {
    private double monthlyBonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double monthlyBonus) {
        super(employeeId, name, baseSalary);
        this.monthlyBonus = monthlyBonus;
    }

    public double getMonthlyBonus() {
        return monthlyBonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + monthlyBonus;
    }
}

// Subclass PartTimeEmployee
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Interface Department
interface Department {
    void assignDepartment(Employee employee, String departmentName);
    String getDepartmentDetails(Employee employee);
}

// Implementation of Department interface
class EmployeeDepartment implements Department {
    private java.util.Map<Integer, String> employeeDepartments = new java.util.HashMap<>();

    @Override
    public void assignDepartment(Employee employee, String departmentName) {
        employeeDepartments.put(employee.getEmployeeId(), departmentName);
        System.out.println("Employee " + employee.getName() + " assigned to " + departmentName + " department.");
    }

    @Override
    public String getDepartmentDetails(Employee employee) {
        if (employeeDepartments.containsKey(employee.getEmployeeId())) {
            return employeeDepartments.get(employee.getEmployeeId());
        } else {
            return "No department assigned";
        }
    }
}

// class to run the application
public class EmployeeOpr {
    public static void main(String[] args) {
        // Create employees
        FullTimeEmployee fullTimeEmployee1 = new FullTimeEmployee(101, "Alice", 50000.00, 10000.00);
        FullTimeEmployee fullTimeEmployee2 = new FullTimeEmployee(102, "Bob", 60000.00, 12000.00);
        PartTimeEmployee partTimeEmployee1 = new PartTimeEmployee(201, "Charlie", 0, 120, 100.00);
        PartTimeEmployee partTimeEmployee2 = new PartTimeEmployee(202, "David", 0, 80, 150.00);

        // Create a list of employees
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(fullTimeEmployee1);
        employeeList.add(fullTimeEmployee2);
        employeeList.add(partTimeEmployee1);
        employeeList.add(partTimeEmployee2);

        // Create a Department object
        EmployeeDepartment department = new EmployeeDepartment();

        // Assign departments to employees
        department.assignDepartment(fullTimeEmployee1, "Engineering");
        department.assignDepartment(fullTimeEmployee2, "Engineering");
        department.assignDepartment(partTimeEmployee1, "Sales");
        department.assignDepartment(partTimeEmployee2, "Sales");

        // Display employee details and department
        System.out.println("\n--- Employee Details ---");
        for (Employee employee : employeeList) {
            employee.displayDetails();
            System.out.println("Department: " + department.getDepartmentDetails(employee));
            System.out.println("----------------------");
        }
    }
}
