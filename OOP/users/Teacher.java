import enums.*;
import java.util.ArrayList;

public class Teacher extends Employee {
    private TeacherTitle title;
    private ArrayList<String> courses = new ArrayList<>();
    private double rating;

    public Teacher(String userId, String firstName, String lastName, String email,
                   String passwordHash, String employeeId, String department,
                   double salary, TeacherTitle title) {
        super(userId, firstName, lastName, email, passwordHash,
              UserRole.TEACHER, employeeId, department, salary);
        this.title = title;
    }

    public void viewCourses() {
        System.out.println(courses);
    }

    public void manageCourse(String course) {
        System.out.println("Managing course: " + course);
    }

    public void putMark(String student, String course, double mark) {
        System.out.println("Mark given");
    }
}