package system;

import users.*;
import enums.*;

// Factory pattern
public class UserFactory {

    public static User createUser(UserRole role, String userId, String firstName,
                                  String lastName, String email, String password) {
        switch (role) {
            case ADMIN:
                return new Admin(userId, firstName, lastName, email, password);
            case STUDENT:
                return new Student(userId, firstName, lastName, email, password,
                                   "S" + userId, 1, StudentDegree.BACHELOR, "CS");
            case TEACHER:
                return new Teacher(userId, firstName, lastName, email, password,
                                   "E" + userId, "CS", 500000, TeacherTitle.LECTOR);
            case MANAGER:
                return new Manager(userId, firstName, lastName, email, password,
                                   "E" + userId, "Admin", 400000, ManagerType.DEPARTMENT);
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }
}
