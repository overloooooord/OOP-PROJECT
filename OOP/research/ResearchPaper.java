package research;

import interfaces.Printable;
import java.util.ArrayList;
import java.util.List;

public class ResearchPaper implements Printable, Comparable<ResearchPaper> {
    private static int counter = 0;
    private String paperId;
    private String title;
    private String authors;
    private String journal;
    private int year;
    private int citations;
    private int pages;

    public ResearchPaper(String title, String authors, String journal, int year, int pages) {
        this.paperId = "RP-" + (++counter);
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.year = year;
        this.pages = pages;
        this.citations = 0;
    }

    public void addCitation() {
        citations++;
    }

    public void setCitations(int citations) {
        this.citations = citations;
    }

    // Getters
    public String getPaperId() { return paperId; }
    public String getTitle() { return title; }
    public String getAuthors() { return authors; }
    public String getJournal() { return journal; }
    public int getYear() { return year; }
    public int getCitations() { return citations; }
    public int getPages() { return pages; }

    @Override
    public int compareTo(ResearchPaper other) {
        return Integer.compare(other.citations, this.citations);
    }

    @Override
    public String print() {
        return "ResearchPaper{title=" + title + ", journal=" + journal +
               ", year=" + year + ", citations=" + citations + "}";
    }

    @Override
    public String toString() {
        return "\"" + title + "\" (" + year + ") - " + journal + " [citations: " + citations + "]";
    }
}
