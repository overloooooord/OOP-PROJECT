package common;

import users.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message implements java.io.Serializable {
    private static int counter = 0;
    private String messageId;
    private User sender;
    private User receiver;
    private String content;
    private LocalDateTime timestamp;

    public Message(User sender, User receiver, String content) {
        this.messageId = "MSG-" + (++counter);
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public String getMessageId() { return messageId; }
    public User getSender() { return sender; }
    public User getReceiver() { return receiver; }
    public String getContent() { return content; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "[" + timestamp.format(DateTimeFormatter.ofPattern("HH:mm")) + "] " +
               sender.getFirstName() + " -> " + receiver.getFirstName() + ": " + content;
    }
}