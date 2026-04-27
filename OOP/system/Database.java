package system;

import users.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Singleton pattern
public class Database {
    private static Database instance;
    private Map<String, User> users = new HashMap<>();

    private Database() {
        // private constructor — singleton
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void removeUser(String userId) {
        users.remove(userId);
    }

    public void updateUser(User user) {
        users.put(user.getUserId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User findByEmail(String email) {
        for (User u : users.values()) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public int getUserCount() {
        return users.size();
    }

    // for testing — reset singleton
    public void clear() {
        users.clear();
    }
}
