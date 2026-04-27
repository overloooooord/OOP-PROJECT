package users;

import enums.*;
import academic.Course;
import academic.Mark;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Employee {
    private TeacherTitle title;
    private List<Course> courses = new ArrayList<>();
    private double rating;
    private int ratingCount;

    public Teacher(String userId, String firstName, String lastName, String email,
                   String passwordHash, String employeeId, String department,
                   double salary, TeacherTitle title) {
        super(userId, firstName, lastName, email, passwordHash,
              UserRole.TEACHER, employeeId, department, salary);
        this.title = title;
        this.rating = 0.0;
        this.ratingCount = 0;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setTeacher(this);
        System.out.println("Teacher " + firstName + " assigned to " + course.getName());
    }

    public void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses assigned.");
            return;
        }
        System.out.println("Courses of " + firstName + " " + lastName + ":");
        for (Course c : courses) {
            System.out.println("  - " + c.getName());
        }
    }

    public void putMark(Student student, Course course, double att1, double att2, double finalExam) {
        Mark mark = new Mark(student, course, att1, att2, finalExam);
        student.addMark(mark);
        System.out.println("Mark given to " + student.getFirstName() + " for " + course.getName() +
                           ": total=" + mark.getTotal());
    }

    public void viewStudents(Course course) {
        System.out.println("Students in " + course.getName() + ":");
        for (Student s : course.getStudents()) {
            System.out.println("  - " + s.getFirstName() + " " + s.getLastName());
        }
    }

    public void addRating(double r) {
        this.rating = (this.rating * ratingCount + r) / (ratingCount + 1);
        this.ratingCount++;
    }

    // Getters
    public TeacherTitle getTitle() { return title; }
    public List<Course> getCourses() { return courses; }
    public double getRating() { return rating; }

    @Override
    public String print() {
        return "Teacher{name=" + firstName + " " + lastName + ", title=" + title +
               ", rating=" + String.format("%.1f", rating) + ", courses=" + courses.size() + "}";
    }
}