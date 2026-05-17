package academic;

import java.io.Serializable;

import users.Student;
import interfaces.Printable;

public class Mark implements Serializable, Printable, Comparable<Mark> {
    private Student student;
    private Course course;
    private double att1;       // attestation 1 (max 30)
    private double att2;       // attestation 2 (max 30)
    private double finalExam;  // final exam (max 40)

    public Mark(Student student, Course course, double att1, double att2, double finalExam) {
        this.student = student;
        this.course = course;
        this.att1 = Math.min(att1, 30);
        this.att2 = Math.min(att2, 30);
        this.finalExam = Math.min(finalExam, 40);
    }

    public double getTotal() {
        return att1 + att2 + finalExam;
    }

    public String getLetterGrade() {
        double total = getTotal();
        if (total >= 90) return "A";
        if (total >= 80) return "B";
        if (total >= 70) return "C";
        if (total >= 60) return "D";
        return "F";
    }

    public double getGpaPoint() {
        double total = getTotal();
        if (total >= 95) return 4.0;
        if (total >= 90) return 3.67;
        if (total >= 85) return 3.33;
        if (total >= 80) return 3.0;
        if (total >= 75) return 2.67;
        if (total >= 70) return 2.33;
        if (total >= 65) return 2.0;
        if (total >= 60) return 1.67;
        if (total >= 55) return 1.33;
        if (total >= 50) return 1.0;
        return 0.0;
    }

    public boolean isPassed() {
        return getTotal() >= 50;
    }

    // Getters
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public double getAtt1() { return att1; }
    public double getAtt2() { return att2; }
    public double getFinalExam() { return finalExam; }

    @Override
    public int compareTo(Mark other) {
        return Double.compare(this.getTotal(), other.getTotal());
    }

    @Override
    public String print() {
        return "Mark{course=" + course.getName() + ", att1=" + att1 + ", att2=" + att2 +
               ", final=" + finalExam + ", total=" + getTotal() + ", grade=" + getLetterGrade() + "}";
    }

    @Override
    public String toString() {
        return course.getName() + ": " + getTotal() + " (" + getLetterGrade() + ")";
    }
}
