package users;

import java.io.Serializable;

import enums.*;
import academic.Course;
import communication.News;
import communication.Request;
import reports.AcademicReport;
import interfaces.Observable;
import interfaces.Observer;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee implements Serializable, Observable {
    private ManagerType managerType;
    private List<Observer> observerList = new ArrayList<>();

    public Manager(String userId, String firstName, String lastName,
                   String email, String passwordHash,
                   String employeeId, String department, double salary,
                   ManagerType managerType) {
        super(userId, firstName, lastName, email, passwordHash,
              UserRole.MANAGER, employeeId, department, salary);
        this.managerType = managerType;
    }

    public void approveRegistration(Request request) {
        request.approve();
        System.out.println("Manager " + firstName + " approved request: " + request.getDescription());
    }

    public void rejectRegistration(Request request) {
        request.reject();
        System.out.println("Manager " + firstName + " rejected request: " + request.getDescription());
    }

    public void addCourseForRegistration(Course course) {
        System.out.println("Course '" + course.getName() + "' added for registration.");
    }

    public void assignTeacher(Teacher teacher, Course course) {
        teacher.addCourse(course);
    }

    public AcademicReport createReport(List<Student> students) {
        AcademicReport report = new AcademicReport(students);
        System.out.println("Academic report created by " + firstName);
        return report;
    }

    public void publishNews(String title, String content) {
        News news = new News(title, content, this);
        notifyObservers(title + ": " + content);
        System.out.println("News published: " + title);
    }

    public void viewStudents(Course course) {
        System.out.println("Students in " + course.getName() + ":");
        for (Student s : course.getStudents()) {
            System.out.println("  - " + s);
        }
    }

    // Observable pattern
    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers(String news) {
        for (Observer o : observerList) {
            o.update(news);
        }
    }

    // Getters
    public ManagerType getManagerType() { return managerType; }

    @Override
    public String print() {
        return "Manager{name=" + firstName + " " + lastName +
               ", type=" + managerType + ", dept=" + department + "}";
    }
}