package academic;

import java.io.Serializable;

import users.Student;
import interfaces.Printable;
import java.util.List;

public class Transcript implements Serializable, Printable {
    private Student student;
    private List<Mark> marks;
    private double gpa;

    public Transcript(Student student, List<Mark> marks) {
        this.student = student;
        this.marks = marks;
        this.gpa = calculateGpa();
    }

    private double calculateGpa() {
        if (marks.isEmpty()) return 0.0;
        double totalPoints = 0;
        int totalCredits = 0;
        for (Mark m : marks) {
            int credits = m.getCourse().getCredits();
            totalPoints += m.getGpaPoint() * credits;
            totalCredits += credits;
        }
        return totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }

    public void printTranscript() {
        System.out.println("=======================================");
        System.out.println("        TRANSCRIPT");
        System.out.println("=======================================");
        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("ID: " + student.getStudentId());
        System.out.println("Major: " + student.getMajor());
        System.out.println("Year: " + student.getYear());
        System.out.println("---------------------------------------");
        System.out.printf("%-20s %6s %6s %5s%n", "Course", "Total", "Grade", "GPA");
        System.out.println("---------------------------------------");
        for (Mark m : marks) {
            System.out.printf("%-20s %6.1f %6s %5.2f%n",
                m.getCourse().getName(),
                m.getTotal(),
                m.getLetterGrade(),
                m.getGpaPoint());
        }
        System.out.println("---------------------------------------");
        System.out.printf("Overall GPA: %.2f%n", gpa);
        System.out.println("=======================================");
    }

    // Getters
    public Student getStudent() { return student; }
    public List<Mark> getMarks() { return marks; }
    public double getGpa() { return gpa; }

    @Override
    public String print() {
        return "Transcript{student=" + student.getFirstName() + " " + student.getLastName() +
               ", courses=" + marks.size() + ", gpa=" + String.format("%.2f", gpa) + "}";
    }
}
