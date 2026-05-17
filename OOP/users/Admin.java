package users;

import java.io.Serializable;

import enums.UserRole;
import system.Database;
import system.Logger;
import java.util.List;

public class Admin extends User implements Serializable {

    public Admin(String userId, String firstName, String lastName,
                 String email, String passwordHash) {
        super(userId, firstName, lastName, email, passwordHash, UserRole.ADMIN);
    }

    public void addUser(User user) {
        Database.getInstance().addUser(user);
        Logger.getInstance().log("Admin " + firstName + " added user: " + user);
        System.out.println("User added: " + user);
    }

    public void removeUser(String userId) {
        Database.getInstance().removeUser(userId);
        Logger.getInstance().log("Admin " + firstName + " removed user: " + userId);
        System.out.println("User removed: " + userId);
    }

    public void updateUser(User user) {
        Database.getInstance().updateUser(user);
        Logger.getInstance().log("Admin " + firstName + " updated user: " + user);
        System.out.println("User updated: " + user);
    }

    public void viewLogs() {
        System.out.println("=== System Logs ===");
        List<String> logs = Logger.getInstance().getLogs();
        for (String log : logs) {
            System.out.println(log);
        }
    }

    public void viewAllUsers() {
        System.out.println("=== All Users ===");
        for (User u : Database.getInstance().getAllUsers()) {
            System.out.println("  " + u.print());
        }
    }

    @Override
    public String print() {
        return "Admin{name=" + firstName + " " + lastName + ", email=" + email + "}";
    }
}