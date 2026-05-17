package communication;

import java.io.Serializable;

import users.User;
import interfaces.Printable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class News implements Serializable, Printable {
    private static int counter = 0;
    private String newsId;
    private String title;
    private String content;
    private User author;
    private LocalDateTime publishDate;

    public News(String title, String content, User author) {
        this.newsId = "NEWS-" + (++counter);
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishDate = LocalDateTime.now();
    }

    // Getters
    public String getNewsId() { return newsId; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public User getAuthor() { return author; }
    public LocalDateTime getPublishDate() { return publishDate; }

    @Override
    public String print() {
        return "News{title=" + title + ", author=" + author.getFirstName() +
               ", date=" + publishDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "}";
    }

    @Override
    public String toString() {
        return "[" + publishDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "] " +
               title + " - " + content;
    }
}
