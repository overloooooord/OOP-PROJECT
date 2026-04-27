import enums.UserRole;
import common.Message;

public abstract class User {
    protected String userId;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String passwordHash;
    protected UserRole role;

    public User(String userId, String firstName, String lastName, String email, String passwordHash, UserRole role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public boolean login(String password) {
        return this.passwordHash.equals(password);
    }

    public void logout() {
        System.out.println(firstName + " logged out");
    }

    public void sendMessage(User to, String text) {
        Message msg = new Message("msg1", this, to, text);
        System.out.println(msg);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}