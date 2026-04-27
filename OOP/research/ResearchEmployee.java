package research;

import users.Employee;
import enums.UserRole;
import exceptions.LowHIndexException;
import java.util.List;

public class ResearchEmployee extends Employee implements Researcher {
    private ResearcherImpl researcherImpl = new ResearcherImpl();
    private static final int MIN_H_INDEX_FOR_PROJECT = 3;

    public ResearchEmployee(String userId, String firstName, String lastName,
                            String email, String passwordHash,
                            String employeeId, String department, double salary) {
        super(userId, firstName, lastName, email, passwordHash,
              UserRole.RESEARCHER, employeeId, department, salary);
    }

    @Override
    public void addResearchPaper(ResearchPaper paper) {
        researcherImpl.addResearchPaper(paper);
    }

    @Override
    public void addResearchProject(ResearchProject project) {
        researcherImpl.addResearchProject(project);
    }

    @Override
    public List<ResearchPaper> getResearchPapers() {
        return researcherImpl.getResearchPapers();
    }

    @Override
    public List<ResearchProject> getResearchProjects() {
        return researcherImpl.getResearchProjects();
    }

    @Override
    public int calculateHIndex() {
        return researcherImpl.calculateHIndex();
    }

    public void startNewProject(String title, String description) throws LowHIndexException {
        int hIndex = calculateHIndex();
        if (hIndex < MIN_H_INDEX_FOR_PROJECT) {
            throw new LowHIndexException(
                "H-index is " + hIndex + ", need at least " + MIN_H_INDEX_FOR_PROJECT +
                " to start a project");
        }
        ResearchProject project = new ResearchProject(title, description);
        addResearchProject(project);
    }

    public void viewResearchInfo() {
        System.out.println("=== Research Info: " + getFirstName() + " " + getLastName() + " ===");
        System.out.println("H-Index: " + calculateHIndex());
        System.out.println("Papers:");
        researcherImpl.printPapers();
        System.out.println("Projects:");
        researcherImpl.printProjects();
    }

    @Override
    public String print() {
        return "ResearchEmployee{name=" + getFirstName() + " " + getLastName() +
               ", h-index=" + calculateHIndex() +
               ", papers=" + getResearchPapers().size() + "}";
    }
}
