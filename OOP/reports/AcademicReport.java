package reports;

import java.io.Serializable;

import users.Student;
import interfaces.Printable;
import java.util.List;

public class AcademicReport implements Serializable, Printable {
    private List<Student> students;

    public AcademicReport(List<Student> students) {
        this.students = students;
    }

    public void generateReport() {
        System.out.println("============================================");
        System.out.println("          ACADEMIC REPORT");
        System.out.println("============================================");
        System.out.printf("%-20s %-10s %-8s %-6s%n", "Student", "Major", "Year", "GPA");
        System.out.println("--------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-20s %-10s %-8d %-6.2f%n",
                s.getFirstName() + " " + s.getLastName(),
                s.getMajor(),
                s.getYear(),
                s.getGpa());
        }
        System.out.println("============================================");
        System.out.println("Total students: " + students.size());
    }

    @Override
    public String print() {
        return "AcademicReport{students=" + students.size() + "}";
    }
}
