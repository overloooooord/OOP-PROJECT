import enums.UserRole;
import java.util.ArrayList;
import common.Message;

public class Employee extends User {
    protected String employeeId;
    protected String department;
    protected double salary;
    protected ArrayList<Message> inbox = new ArrayList<>();

    public Employee(String userId, String firstName, String lastName, String email,
                    String passwordHash, UserRole role,
                    String employeeId, String department, double salary) {
        super(userId, firstName, lastName, email, passwordHash, role);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    public void sendComplaint(String text) {
        System.out.println("Complaint sent: " + text);
    }

    public void viewInbox() {
        inbox.forEach(System.out::println);
    }
}