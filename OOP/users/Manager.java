import enums.*;
import java.util.ArrayList;

public class Manager extends Employee {
    private ManagerType managerType;

    public Manager(String userId, String firstName, String lastName,
                   String email, String passwordHash,
                   String employeeId, String department, double salary,
                   ManagerType managerType) {
        super(userId, firstName, lastName, email, passwordHash,
              UserRole.MANAGER, employeeId, department, salary);
        this.managerType = managerType;
    }

    public void approveRegistration(String student, String course) {
        System.out.println("Approved");
    }

    public void createReport() {
        System.out.println("Report created");
    }
}