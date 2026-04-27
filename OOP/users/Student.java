import enums.*;
import java.util.ArrayList;

public class Student extends User {
    private String studentId;
    private int year;
    private StudentDegree degree;
    private String major;
    private double gpa;

    private ArrayList<String> registeredCourses = new ArrayList<>();

    public Student(String userId, String firstName, String lastName,
                   String email, String passwordHash,
                   String studentId, int year, StudentDegree degree, String major) {
        super(userId, firstName, lastName, email, passwordHash, UserRole.STUDENT);
        this.studentId = studentId;
        this.year = year;
        this.degree = degree;
        this.major = major;
    }

    public void registerForCourse(String course) {
        registeredCourses.add(course);
    }

    public void viewMarks() {
        System.out.println("Marks shown");
    }
}