package system;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Singleton pattern
public class Logger implements Serializable {
    private static Logger instance;
    private List<String> logs = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    private Logger() {
        // private constructor — singleton
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        String entry = "[" + LocalDateTime.now().format(formatter) + "] " + message;
        logs.add(entry);
    }

    public List<String> getLogs() {
        return new ArrayList<>(logs);
    }

    public void printLogs() {
        if (logs.isEmpty()) {
            System.out.println("No logs.");
            return;
        }
        for (String log : logs) {
            System.out.println(log);
        }
    }

    public void clear() {
        logs.clear();
    }
}
