import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private int age;
    private String department;
    private ArrayList<Course> enrolledCourses = new ArrayList<>();

    public Student(String studentId, String name, int age, String department) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + "\nName: " + name + "\nAge: " + age + "\nDepartment: " + department;
    }
}

class Course {
    private String courseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseId + "\nCourse Name: " + courseName;
    }
}

public class cms {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nCollege Management System Menu");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. View Student Details");
            System.out.println("5. View Course Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    enrollStudentInCourse();
                    break;
                case 4:
                    viewStudentDetails();
                    break;
                case 5:
                    viewCourseDetails();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private static void addStudent() {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Student Department: ");
        String department = scanner.nextLine();

        Student student = new Student(studentId, name, age, department);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    private static void addCourse() {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        Course course = new Course(courseId, courseName);
        courses.add(course);
        System.out.println("Course added successfully.");
    }

    private static void enrollStudentInCourse() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter Course ID: ");
        String courseId = scanner.next();

        Student student = findStudent(studentId);
        Course course = findCourse(courseId);

        if (student != null && course != null) {
            student.enrollCourse(course);
            System.out.println("Student enrolled in the course successfully.");
        } else {
            System.out.println("Student or course not found.");
        }
    }

    private static void viewStudentDetails() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();

        Student student = findStudent(studentId);
        if (student != null) {
            System.out.println(student);
            System.out.println("Enrolled Courses:");
            for (Course course : student.getEnrolledCourses()) {
                System.out.println(course);
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewCourseDetails() {
        System.out.print("Enter Course ID: ");
        String courseId = scanner.next();

        Course course = findCourse(courseId);
        if (course != null) {
            System.out.println(course);
        } else {
            System.out.println("Course not found.");
        }
    }

    private static Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourse(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
}
