import java.util.ArrayList;
import java.util.List;

public class CompanyManagement {

    static class Employee {
        private final String name;
        private int id;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void displayInfo() {
            System.out.println("Employee ID: " + id + ", Name: " + name);
        }
    }

    static class Department {
        private String deptName;
        private List<Employee> employees;

        public Department(String deptName) {
            this.deptName = deptName;
            this.employees = new ArrayList<>();
        }

        public void addEmployee(int id, String name) {
            employees.add(new Employee(id, name));
        }

        public String getDeptName() {
            return deptName;
        }

        public void displayDepartment() {
            System.out.println("\nDepartment: " + deptName);
            for (Employee e : employees) {
                e.displayInfo();
            }
        }
    }

    static class Company {
        private String name;
        private List<Department> departments;

        public Company(String name) {
            this.name = name;
            this.departments = new ArrayList<>();
        }

        public void addDepartment(String deptName) {
            departments.add(new Department(deptName));
        }

        public Department getDepartment(String deptName) {
            for (Department d : departments) {
                if (d.getDeptName().equals(deptName)) {
                    return d;
                }
            }
            return null;
        }

        public void showCompanyStructure() {
            System.out.println("\nCompany: " + name);
            for (Department d : departments) {
                d.displayDepartment();
            }
        }
    }

    public static void main(String[] args) {
        Company company = new Company("TechNova Solutions");

        company.addDepartment("Engineering");
        company.addDepartment("HR");

        Department eng = company.getDepartment("Engineering");
        if (eng != null) {
            eng.addEmployee(101, "fz");
            eng.addEmployee(203, "yz");
        }

        Department hr = company.getDepartment("HR");
        if (hr != null) {
            hr.addEmployee(402, "Raghu");
        }

        company.showCompanyStructure();
    }
}
