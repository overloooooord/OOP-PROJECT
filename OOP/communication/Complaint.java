package communication;

import enums.RequestStatus;
import users.User;
import interfaces.Printable;

public class Complaint implements Printable {
    private static int counter = 0;
    private String complaintId;
    private User sender;
    private String subject;
    private String description;
    private RequestStatus status;

    public Complaint(User sender, String subject, String description) {
        this.complaintId = "CMP-" + (++counter);
        this.sender = sender;
        this.subject = subject;
        this.description = description;
        this.status = RequestStatus.PENDING;
    }

    public void resolve() {
        this.status = RequestStatus.APPROVED;
        System.out.println("Complaint " + complaintId + " resolved.");
    }

    // Getters
    public String getComplaintId() { return complaintId; }
    public User getSender() { return sender; }
    public String getSubject() { return subject; }
    public String getDescription() { return description; }
    public RequestStatus getStatus() { return status; }

    @Override
    public String print() {
        return "Complaint{id=" + complaintId + ", subject=" + subject +
               ", status=" + status + "}";
    }

    @Override
    public String toString() {
        return "[" + status + "] " + subject + ": " + description;
    }
}
