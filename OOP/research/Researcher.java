package research;

import java.util.List;

public interface Researcher {
    void addResearchPaper(ResearchPaper paper);
    void addResearchProject(ResearchProject project);
    List<ResearchPaper> getResearchPapers();
    List<ResearchProject> getResearchProjects();
    int calculateHIndex();
}
