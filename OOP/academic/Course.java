package academic;

import users.Teacher;
import users.Student;
import enums.LessonType;
import interfaces.Printable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Printable, java.io.Serializable {
    private String courseId;
    private String name;
    private int credits;
    private int maxStudents;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Lesson> lessons = new ArrayList<>();

    public Course(String courseId, String name, int credits, int maxStudents) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.maxStudents = maxStudents;
    }

    public void addStudent(Student student) {
        if (students.size() < maxStudents) {
            students.add(student);
        } else {
            System.out.println("Course " + name + " is full!");
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void addLesson(LessonType type, String topic, Teacher teacher) {
        Lesson lesson = new Lesson(type, topic, teacher);
        lessons.add(lesson);
    }

    public void addTeacher(Teacher teacher) {
        if (!teachers.contains(teacher)) {
            this.teachers.add(teacher);
        }
    }

    // Getters
    public String getCourseId() { return courseId; }
    public String getName() { return name; }
    public int getCredits() { return credits; }
    public int getMaxStudents() { return maxStudents; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Student> getStudents() { return students; }
    public List<Lesson> getLessons() { return lessons; }

    @Override
    public String print() {
        return "Course{id=" + courseId + ", name=" + name + ", credits=" + credits +
               ", students=" + students.size() + "/" + maxStudents + "}";
    }

    @Override
    public String toString() {
        return name + " (" + credits + " credits)";
    }
}
