import users.User;
import java.time.LocalDateTime;

public class Message {
    private String messageId;
    private User sender;
    private User receiver;
    private String content;
    private LocalDateTime timestamp;

    public Message(String messageId, User sender, User receiver, String content) {
        this.messageId = messageId;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return sender + " -> " + receiver + ": " + content;
    }
}