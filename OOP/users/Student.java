package users;

import java.io.Serializable;

import enums.*;
import academic.Course;
import academic.Mark;
import academic.Transcript;
import exceptions.MaxCreditsExceededException;
import interfaces.Observer;
import java.util.ArrayList;
import java.util.List;

public class Student extends User implements Serializable, Observer {
    private String studentId;
    private int year;
    private StudentDegree degree;
    private String major;
    private double gpa;
    private int totalCredits;

    private static final int MAX_CREDITS = 21;

    private List<Course> registeredCourses = new ArrayList<>();
    private List<Mark> marks = new ArrayList<>();
    private List<String> notifications = new ArrayList<>();

    public Student(String userId, String firstName, String lastName,
                   String email, String passwordHash,
                   String studentId, int year, StudentDegree degree, String major) {
        super(userId, firstName, lastName, email, passwordHash, UserRole.STUDENT);
        this.studentId = studentId;
        this.year = year;
        this.degree = degree;
        this.major = major;
        this.gpa = 0.0;
        this.totalCredits = 0;
    }

    public void registerForCourse(Course course) throws MaxCreditsExceededException {
        if (totalCredits + course.getCredits() > MAX_CREDITS) {
            throw new MaxCreditsExceededException(
                "Cannot register: total credits would be " + (totalCredits + course.getCredits()) +
                ", max is " + MAX_CREDITS);
        }
        registeredCourses.add(course);
        course.addStudent(this);
        totalCredits += course.getCredits();
        System.out.println(firstName + " registered for " + course.getName());
    }

    public void viewMarks() {
        if (marks.isEmpty()) {
            System.out.println("No marks yet.");
            return;
        }
        for (Mark m : marks) {
            System.out.println(m);
        }
    }

    public void addMark(Mark mark) {
        marks.add(mark);
    }

    public Transcript getTranscript() {
        return new Transcript(this, marks);
    }

    public void rateTeacher(Teacher teacher, double rating) {
        teacher.addRating(rating);
        System.out.println(firstName + " rated " + teacher.getFirstName() + ": " + rating);
    }

    @Override
    public void update(String news) {
        notifications.add(news);
        System.out.println("[" + firstName + "] got notification: " + news);
    }

    // Getters
    public String getStudentId() { return studentId; }
    public int getYear() { return year; }
    public StudentDegree getDegree() { return degree; }
    public String getMajor() { return major; }
    public double getGpa() { return gpa; }
    public List<Course> getRegisteredCourses() { return registeredCourses; }
    public List<Mark> getMarks() { return marks; }
    public int getTotalCredits() { return totalCredits; }

    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String print() {
        return "Student{id=" + studentId + ", name=" + firstName + " " + lastName +
               ", year=" + year + ", degree=" + degree + ", major=" + major +
               ", gpa=" + gpa + "}";
    }
}