package research;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResearcherImpl implements Researcher {
    private List<ResearchPaper> papers = new ArrayList<>();
    private List<ResearchProject> projects = new ArrayList<>();

    @Override
    public void addResearchPaper(ResearchPaper paper) {
        papers.add(paper);
        System.out.println("Paper added: " + paper.getTitle());
    }

    @Override
    public void addResearchProject(ResearchProject project) {
        projects.add(project);
        System.out.println("Project added: " + project.getTitle());
    }

    @Override
    public List<ResearchPaper> getResearchPapers() {
        return papers;
    }

    @Override
    public List<ResearchProject> getResearchProjects() {
        return projects;
    }

    @Override
    public int calculateHIndex() {
        List<Integer> citations = new ArrayList<>();
        for (ResearchPaper p : papers) {
            citations.add(p.getCitations());
        }
        Collections.sort(citations, Collections.reverseOrder());

        int h = 0;
        for (int i = 0; i < citations.size(); i++) {
            if (citations.get(i) >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        return h;
    }

    public void printPapers() {
        if (papers.isEmpty()) {
            System.out.println("No research papers.");
            return;
        }
        for (ResearchPaper p : papers) {
            System.out.println("  " + p);
        }
    }

    public void printProjects() {
        if (projects.isEmpty()) {
            System.out.println("No research projects.");
            return;
        }
        for (ResearchProject p : projects) {
            System.out.println("  " + p);
        }
    }
}
