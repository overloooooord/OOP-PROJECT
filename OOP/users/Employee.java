package users;

import java.io.Serializable;

import enums.UserRole;

public class Employee extends User implements Serializable {
    protected String employeeId;
    protected String department;
    protected double salary;

    public Employee(String userId, String firstName, String lastName, String email,
                    String passwordHash, UserRole role,
                    String employeeId, String department, double salary) {
        super(userId, firstName, lastName, email, passwordHash, role);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public String getEmployeeId() { return employeeId; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    // Setters
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String print() {
        return "Employee{id=" + employeeId + ", name=" + firstName + " " + lastName +
               ", dept=" + department + ", salary=" + salary + "}";
    }
}