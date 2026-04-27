package communication;

import enums.RequestStatus;
import users.User;
import interfaces.Printable;

public class Request implements Printable {
    private static int counter = 0;
    private String requestId;
    private User sender;
    private String description;
    private RequestStatus status;

    public Request(User sender, String description) {
        this.requestId = "REQ-" + (++counter);
        this.sender = sender;
        this.description = description;
        this.status = RequestStatus.PENDING;
    }

    public void approve() {
        this.status = RequestStatus.APPROVED;
    }

    public void reject() {
        this.status = RequestStatus.REJECTED;
    }

    // Getters
    public String getRequestId() { return requestId; }
    public User getSender() { return sender; }
    public String getDescription() { return description; }
    public RequestStatus getStatus() { return status; }

    @Override
    public String print() {
        return "Request{id=" + requestId + ", from=" + sender.getFirstName() +
               ", desc=" + description + ", status=" + status + "}";
    }

    @Override
    public String toString() {
        return "[" + status + "] " + description + " (from: " + sender.getFirstName() + ")";
    }
}
