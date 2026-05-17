package system;

import java.io.*;
import users.User;
import research.Researcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Singleton pattern
public class Database implements Serializable {
    private static final String FILE_PATH = "database.dat";
    private static Database instance;
    private Map<String, User> users = new HashMap<>();

    private Database() {
        // private constructor — singleton
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = loadDatabase();
            if (instance == null) {
                instance = new Database();
            }
        }
        return instance;
    }

    private static Database loadDatabase() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (Database) ois.readObject();
        } catch (FileNotFoundException e) {
            // first run
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading database: " + e.getMessage());
            return null;
        }
    }

    private void saveDatabase() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println("Error saving database: " + e.getMessage());
        }
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
        saveDatabase();
    }

    public void removeUser(String userId) {
        users.remove(userId);
        saveDatabase();
    }

    public void updateUser(User user) {
        users.put(user.getUserId(), user);
        saveDatabase();
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

    public void printTopCitedResearcher() {
        Researcher top = null;
        int maxCitations = -1;
        for (User u : users.values()) {
            if (u instanceof Researcher) {
                Researcher r = (Researcher) u;
                int currentCitations = 0;
                for (research.ResearchPaper p : r.getResearchPapers()) {
                    currentCitations += p.getCitations();
                }
                if (currentCitations > maxCitations) {
                    maxCitations = currentCitations;
                    top = r;
                }
            }
        }
        if (top != null) {
            System.out.println("Top Cited Researcher: " + top + " with " + maxCitations + " citations.");
        } else {
            System.out.println("No researchers found.");
        }
    }

    // for testing — reset singleton
    public void clear() {
        users.clear();
        saveDatabase();
    }
}
