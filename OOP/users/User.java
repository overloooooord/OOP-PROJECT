package users;

import enums.UserRole;
import common.Message;
import interfaces.Printable;
import java.util.ArrayList;
import java.util.List;

public abstract class User implements Printable, Comparable<User>, java.io.Serializable {
    protected String userId;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String passwordHash;
    protected UserRole role;
    protected boolean isLoggedIn;
    protected List<Message> inbox = new ArrayList<>();

    public User(String userId, String firstName, String lastName, String email,
                String passwordHash, UserRole role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.isLoggedIn = false;
    }

    public boolean login(String password) {
        if (this.passwordHash.equals(password)) {
            this.isLoggedIn = true;
            System.out.println(firstName + " " + lastName + " logged in.");
            return true;
        }
        System.out.println("Wrong password for " + email);
        return false;
    }

    public void logout() {
        this.isLoggedIn = false;
        System.out.println(firstName + " " + lastName + " logged out.");
    }

    public void sendMessage(User to, String text) {
        Message msg = new Message(this, to, text);
        to.receiveMessage(msg);
        System.out.println("Message sent: " + this.firstName + " -> " + to.firstName);
    }

    public void receiveMessage(Message msg) {
        inbox.add(msg);
    }

    public void viewInbox() {
        if (inbox.isEmpty()) {
            System.out.println("Inbox is empty.");
            return;
        }
        for (Message m : inbox) {
            System.out.println(m);
        }
    }

    // Getters
    public String getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public UserRole getRole() { return role; }
    public boolean isLoggedIn() { return isLoggedIn; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String print() {
        return "User{id=" + userId + ", name=" + firstName + " " + lastName +
               ", email=" + email + ", role=" + role + "}";
    }

    @Override
    public int compareTo(User other) {
        return this.lastName.compareTo(other.lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + role + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }
}