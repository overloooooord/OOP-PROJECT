import enums.UserRole;
import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<String> logAccess = new ArrayList<>();

    public Admin(String userId, String firstName, String lastName,
                 String email, String passwordHash) {
        super(userId, firstName, lastName, email, passwordHash, UserRole.ADMIN);
    }

    public void addUser(User user) {
        System.out.println("User added: " + user);
    }

    public void removeUser(String userId) {
        System.out.println("User removed: " + userId);
    }

    public void updateUser(User user) {
        System.out.println("User updated: " + user);
    }

    public void viewLogs() {
        logAccess.forEach(System.out::println);
    }
}