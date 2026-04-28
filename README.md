# User Role Management System

## Project Description

User Role Management System is a university management system designed to organize users, academic processes, research activities, requests, and communication inside an educational institution.

The system is based on Object-Oriented Programming principles and represents different university roles such as students, teachers, managers, admins, and researchers.

## Main Features

- User authentication: login and logout
- Role-based user management
- Student course registration
- Teacher course management
- Mark calculation and transcript generation
- Manager approval of requests and course registration
- Research paper and research project management
- Internal messaging between users
- Complaint and request handling
- News publishing
- Logging user actions
- Centralized data storage using a singleton database

## User Roles

### Admin
Admin manages users and views system logs.

Main responsibilities:
- Add users
- Remove users
- Update user information
- View logs

### Student
Student can register for courses, view marks, generate transcripts, and rate teachers.

Main responsibilities:
- Register for courses
- View marks
- Get transcript
- Rate teachers
- Choose research supervisor

### Teacher
Teacher manages courses, puts marks, and views students.

Main responsibilities:
- View courses
- Manage courses
- Put marks
- View students

### Manager
Manager controls academic processes and handles requests.

Main responsibilities:
- Approve course registration
- Add courses for registration
- Assign teachers to courses
- Create academic reports
- Manage news
- View student lists
- Process requests

### Researcher
Researcher works with research papers and research projects.

Main responsibilities:
- Add research papers
- Add research projects
- View research papers
- View research projects
- Calculate h-index

## Project Structure

```text
src/
├── users/
│   ├── User.java
│   ├── Student.java
│   ├── Employee.java
│   ├── Teacher.java
│   ├── Manager.java
│   └── Admin.java
│
├── academic/
│   ├── Course.java
│   ├── Lesson.java
│   ├── Mark.java
│   └── Transcript.java
│
├── research/
│   ├── Researcher.java
│   ├── ResearcherImpl.java
│   ├── ResearchEmployee.java
│   ├── ResearchPaper.java
│   └── ResearchProject.java
│
├── communication/
│   ├── Message.java
│   ├── Request.java
│   ├── Complaint.java
│   └── News.java
│
├── system/
│   ├── Database.java
│   ├── Logger.java
│   └── UserFactory.java
│
├── reports/
│   └── AcademicReport.java
│
├── enums/
│   ├── UserRole.java
│   ├── TeacherTitle.java
│   ├── ManagerType.java
│   ├── LessonType.java
│   ├── StudentDegree.java
│   └── RequestStatus.java
│
├── interfaces/
│   ├── Printable.java
│   ├── Observable.java
│   └── Observer.java
│
└── exceptions/
    ├── LowHIndexException.java
    ├── NotAResearcherException.java
    ├── MaxCreditsExceededException.java
    └── MaxFailsExceededException.java