package research;

import interfaces.Printable;
import java.util.ArrayList;
import java.util.List;

public class ResearchProject implements Printable {
    private static int counter = 0;
    private String projectId;
    private String title;
    private String description;
    private List<ResearchPaper> publishedPapers = new ArrayList<>();
    private boolean isActive;

    public ResearchProject(String title, String description) {
        this.projectId = "PROJ-" + (++counter);
        this.title = title;
        this.description = description;
        this.isActive = true;
    }

    public void addPaper(ResearchPaper paper) {
        publishedPapers.add(paper);
    }

    public void finish() {
        this.isActive = false;
        System.out.println("Project '" + title + "' finished.");
    }

    // Getters
    public String getProjectId() { return projectId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public List<ResearchPaper> getPublishedPapers() { return publishedPapers; }
    public boolean isActive() { return isActive; }

    @Override
    public String print() {
        return "ResearchProject{title=" + title + ", papers=" + publishedPapers.size() +
               ", active=" + isActive + "}";
    }

    @Override
    public String toString() {
        return title + " [" + (isActive ? "ACTIVE" : "FINISHED") + ", papers: " + publishedPapers.size() + "]";
    }
}
