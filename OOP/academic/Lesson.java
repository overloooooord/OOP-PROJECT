package academic;

import java.io.Serializable;

import enums.LessonType;
import users.Teacher;
import interfaces.Printable;

public class Lesson implements Serializable, Printable {
    private static int counter = 0;
    private String lessonId;
    private LessonType type;
    private String topic;
    private Teacher teacher;

    public Lesson(LessonType type, String topic, Teacher teacher) {
        this.lessonId = "L-" + (++counter);
        this.type = type;
        this.topic = topic;
        this.teacher = teacher;
    }

    // Getters
    public String getLessonId() { return lessonId; }
    public LessonType getType() { return type; }
    public String getTopic() { return topic; }
    public Teacher getTeacher() { return teacher; }

    @Override
    public String print() {
        return "Lesson{type=" + type + ", topic=" + topic + "}";
    }

    @Override
    public String toString() {
        return type + ": " + topic;
    }
}
