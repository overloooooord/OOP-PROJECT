import users.*;
import academic.*;
import research.*;
import communication.*;
import reports.*;
import system.*;
import enums.*;
import exceptions.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("=".repeat(50));
        System.out.println("  UNIVERSITY MANAGEMENT SYSTEM — DEMO");
        System.out.println("=".repeat(50));

        // ==============================
        // 1. SYSTEM — Singleton patterns
        // ==============================
        System.out.println("\n--- 1. Singleton: Database & Logger ---");
        Database db = Database.getInstance();
        Logger logger = Logger.getInstance();
        logger.log("System started");

        // ==============================
        // 2. USERS — Factory pattern
        // ==============================
        System.out.println("\n--- 2. Factory: Creating users ---");

        // Admin
        Admin admin = new Admin("U001", "Amir", "Kabdullin", "amir@kbtu.kz", "admin123");

        // Students
        Student student1 = new Student("U002", "Aliya", "Nurova", "aliya@kbtu.kz", "pass1",
                "S001", 2, StudentDegree.BACHELOR, "CS");
        Student student2 = new Student("U003", "Bolat", "Serik", "bolat@kbtu.kz", "pass2",
                "S002", 3, StudentDegree.BACHELOR, "IS");

        // Teacher
        Teacher teacher = new Teacher("U004", "Marat", "Tulegenov", "marat@kbtu.kz", "tpass",
                "E001", "CS", 600000, TeacherTitle.ASSOCIATE_PROFESSOR);

        // Manager
        Manager manager = new Manager("U005", "Dinara", "Akhmetova", "dinara@kbtu.kz", "mpass",
                "E002", "Dean Office", 500000, ManagerType.DEAN_OFFICE);

        // Factory usage
        User factoryUser = UserFactory.createUser(UserRole.STUDENT, "U010",
                "Test", "Student", "test@kbtu.kz", "test123");
        System.out.println("Factory created: " + factoryUser.print());

        // Admin adds users to DB
        admin.addUser(student1);
        admin.addUser(student2);
        admin.addUser(teacher);
        admin.addUser(manager);

        // ==============================
        // 3. LOGIN / LOGOUT
        // ==============================
        System.out.println("\n--- 3. Login / Logout ---");
        student1.login("pass1");
        student1.login("wrongPassword");
        teacher.login("tpass");

        // ==============================
        // 4. MESSAGING
        // ==============================
        System.out.println("\n--- 4. Messaging ---");
        student1.sendMessage(teacher, "When is the midterm?");
        teacher.sendMessage(student1, "Next Monday!");
        student1.viewInbox();

        // ==============================
        // 5. ACADEMIC — Courses & Registration
        // ==============================
        System.out.println("\n--- 5. Courses & Registration ---");
        Course oop = new Course("C001", "OOP", 5, 30);
        Course algo = new Course("C002", "Algorithms", 4, 25);
        Course db_course = new Course("C003", "Databases", 6, 20);

        // Manager assigns teacher
        manager.assignTeacher(teacher, oop);
        manager.addCourseForRegistration(oop);

        // Students register
        try {
            student1.registerForCourse(oop);
            student1.registerForCourse(algo);
            student2.registerForCourse(oop);
        } catch (MaxCreditsExceededException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Show course students
        teacher.viewCourses();
        teacher.viewStudents(oop);

        // ==============================
        // 6. MARKS & TRANSCRIPT
        // ==============================
        System.out.println("\n--- 6. Marks & Transcript ---");
        teacher.putMark(student1, oop, 28, 27, 35);
        teacher.putMark(student1, algo, 25, 22, 30);
        teacher.putMark(student2, oop, 20, 18, 25);

        student1.viewMarks();

        // Transcript
        System.out.println();
        Transcript transcript = student1.getTranscript();
        transcript.printTranscript();

        // ==============================
        // 7. REQUESTS & COMPLAINTS
        // ==============================
        System.out.println("\n--- 7. Requests & Complaints ---");
        Request request = new Request(student1, "Register for Databases course");
        System.out.println("Before: " + request);
        manager.approveRegistration(request);
        System.out.println("After: " + request);

        Complaint complaint = new Complaint(student2, "Room too cold",
                "The lecture hall is very cold, please fix heating");
        System.out.println(complaint);
        complaint.resolve();

        // ==============================
        // 8. OBSERVER — News
        // ==============================
        System.out.println("\n--- 8. Observer Pattern: News ---");
        manager.addObserver(student1);
        manager.addObserver(student2);
        manager.publishNews("Exam Schedule", "Finals start on June 1st");

        // ==============================
        // 9. RESEARCH
        // ==============================
        System.out.println("\n--- 9. Research ---");
        ResearchEmployee researcher = new ResearchEmployee("U006", "Aidar", "Moldabay",
                "aidar@kbtu.kz", "rpass", "E003", "CS", 700000);
        admin.addUser(researcher);

        // Add papers with citations
        ResearchPaper paper1 = new ResearchPaper("ML in Education", "Aidar M.",
                "IEEE Journal", 2024, 12);
        paper1.setCitations(15);

        ResearchPaper paper2 = new ResearchPaper("Deep Learning for NLP", "Aidar M.",
                "ACM Computing", 2023, 8);
        paper2.setCitations(10);

        ResearchPaper paper3 = new ResearchPaper("AI Ethics", "Aidar M.",
                "Nature AI", 2025, 6);
        paper3.setCitations(5);

        researcher.addResearchPaper(paper1);
        researcher.addResearchPaper(paper2);
        researcher.addResearchPaper(paper3);

        System.out.println("H-Index: " + researcher.calculateHIndex());
        researcher.viewResearchInfo();

        System.out.println("\n--- Sorted Papers (By Citations via Comparator Strategy) ---");
        researcher.printPapers((p1, p2) -> Integer.compare(p2.getCitations(), p1.getCitations()));

        System.out.println("\n--- Top Cited Researcher in University ---");
        db.printTopCitedResearcher();

        // Try to start a project (needs h-index >= 3)
        try {
            researcher.startNewProject("AI in Universities", "Applying AI to university management");
        } catch (LowHIndexException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // ==============================
        // 10. ACADEMIC REPORT
        // ==============================
        System.out.println("\n--- 10. Academic Report ---");
        AcademicReport report = manager.createReport(Arrays.asList(student1, student2));
        report.generateReport();

        // ==============================
        // 11. ADMIN — Logs & Users
        // ==============================
        System.out.println("\n--- 11. Admin: View Logs ---");
        logger.log("Demo finished");
        admin.viewLogs();

        System.out.println("\n--- 12. Admin: View All Users ---");
        admin.viewAllUsers();

        // ==============================
        // 12. Printable interface demo
        // ==============================
        System.out.println("\n--- 13. Printable Interface ---");
        System.out.println(student1.print());
        System.out.println(teacher.print());
        System.out.println(oop.print());
        System.out.println(paper1.print());

        // ==============================
        // LOGOUT
        // ==============================
        System.out.println("\n--- Logout ---");
        student1.logout();
        teacher.logout();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("  DEMO COMPLETED SUCCESSFULLY");
        System.out.println("=".repeat(50));
    }
}
