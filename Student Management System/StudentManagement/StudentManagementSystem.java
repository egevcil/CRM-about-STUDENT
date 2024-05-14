//Ege Evcil 200218025 Software Engineering Student (CRM Project(BASED ON STUDENT DETAILS))
package StudentManagement;
import java.util.ArrayList;
import java.util.Scanner;

// Decorator Base Class
abstract class StudentManagementDecorator extends StudentManagementSystem {
    protected StudentManagementSystem decoratedStudentManagement;

    public StudentManagementDecorator(StudentManagementSystem decoratedStudentManagement) {
        super();
        this.decoratedStudentManagement = decoratedStudentManagement;
    }

    public void add() {
        decoratedStudentManagement.add();
    }

    public void remove() { decoratedStudentManagement.remove(); }

    public void view() {
        decoratedStudentManagement.view();
    }

    public void grades() {
        decoratedStudentManagement.grades();
    }

    public void feedback() {
        decoratedStudentManagement.feedback();
    }

    public void attendance() {
        decoratedStudentManagement.attendance();
    }
}

//Decorator Class
class Decorator extends StudentManagementDecorator {
    public Decorator(StudentManagementSystem decoratedStudentManagement) {
        super(decoratedStudentManagement);
    }

    @Override
    public void add() {

        super.add();
    }

}
public class StudentManagementSystem {
    private static final StudentManagementSystem instance = new StudentManagementSystem();
    private static ArrayList<String> u_Roll;
    private static ArrayList<String> u_Name;
    private static ArrayList<String> u_Age;
    private static ArrayList<String> u_Course;
    private static Scanner scanner;
    private static StudentManagementSystem getInstance() {
        return instance;
    }
    StudentManagementSystem() {
        u_Roll = new ArrayList<>();
        u_Name = new ArrayList<>();
        u_Age = new ArrayList<>();
        u_Course = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    // Other methods
    public void add() {
        System.out.println("----------------------------------- ADD STUDENTS -----------------------------------");
        String ROLL = scanner.nextLine();
        if (!checking(ROLL)) {

            System.out.print("\tRoll_No: ");
            u_Roll.add(scanner.nextLine());

            System.out.print("\tName: ");
            u_Name.add(scanner.nextLine());

            System.out.print("\tAge: ");
            u_Age.add(scanner.nextLine());

            System.out.print("\tCourse: ");
            u_Course.add(scanner.nextLine());

            System.out.println("\nNew Student is added.");
        } else {
            System.out.println("Student data is already in records.");
        }
    }


    public void remove() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Removing student profile...");
        System.out.print("Enter Roll no of the student: ");
        String ROLL = scanner.nextLine();

        // Assuming u_Roll is an ArrayList containing student roll numbers
        int index = u_Roll.indexOf(ROLL); // Check for the index of the ROLL in the list

        if (index >= 0) { // Check if the index is valid (>= 0)
            System.out.println("Student with roll number " + ROLL + " found.");

            // Remove elements from corresponding lists using the index
            u_Name.remove(index);
            u_Age.remove(index);
            u_Roll.remove(index);
            u_Course.remove(index);

            System.out.println("Record removed successfully.");
        } else {
            System.out.println("Sorry, record not found for roll number: " + ROLL);
        }
    }



    public void view() {
        System.out.println("Viewing student profile...");
        System.out.println("*********************************** VIEW ***********************************");
        for (int l = 0; l < u_Name.size(); l++) {
            System.out.println(u_Name.get(l) + " " + u_Age.get(l) + " " + u_Roll.get(l) + " " + u_Course.get(l));
        }
        System.out.println("****************************************************************************");
    }

    public void grades() {
        System.out.println("Inputting student's grades...");
        System.out.println("***************** INPUTTED STUDENT'S GRADE *****************");

        System.out.print("Enter the grade: (Example: A+, B-, C, ...): ");
        String grade = scanner.next();
        System.out.println("Grade is taken... Grade: " + grade);
    }

    public void feedback() {
        System.out.println("Inputting student's feedback...");
        System.out.println("**************** INPUTTED STUDENT'S FEEDBACK ****************");

        System.out.print("Give your feedback: (Example: Good or bad?) ");
        String feedback = scanner.next();
        System.out.println("Feedback successfully sent! feedback: " + feedback);
    }

    public void attendance() {
        System.out.println("Inputting student's attendance...");
        System.out.println("**************** INPUTTED STUDENT'S ATTENDANCE ****************");

        float attendance;
        while (true) {
            System.out.print("Enter student's attendance percentage (between 0 and 100): ");
            attendance = scanner.nextFloat();

            if (attendance < 0 || attendance > 100) {
                System.out.println("Invalid percentage! Please enter a value between 0 and 100.");
            } else {
                break; // Exit loop if valid input is received
            }
        }

        System.out.println("Percentage of attendance recorded: " + attendance);
    }

    private boolean checking(String roll) {
        return u_Roll.contains(roll);
    }
    private int userRoll(String roll) {
        return u_Roll.indexOf(roll);
    }

    // Main method
    public static void main(String[] args) {
        // Decorate the base StudentManagementSystem with additional authentication steps
        StudentManagementSystem decoratedStudentManagement = new Decorator(instance);

        int user = 10000;
        while (user != 0) {
            System.out.println("\t\tMain Menu");
            System.out.println("------------------------------------------");
            System.out.println("1)Add Student\n2)Remove Student\n3)View\n4)Student Grades\n5)Student Feedback\n6)Student Attendance\n7)Exit");
            System.out.println("------------------------------------------");
            System.out.print("Welcome to Student Management System (Abbreviation: SRM)\nChoose your management category.\n\tEnter the No. of upper options: ");

            user = Integer.parseInt(scanner.next());

            switch (user) {
                case 1:
                    decoratedStudentManagement.getInstance().add();
                    break;
                case 2:
                    decoratedStudentManagement.getInstance().remove();
                    break;
                case 3:
                    decoratedStudentManagement.getInstance().view();
                    break;
                case 4:
                    decoratedStudentManagement.getInstance().grades();
                    break;
                case 5:
                    decoratedStudentManagement.getInstance().feedback();
                    break;
                case 6:
                    decoratedStudentManagement.getInstance().attendance();
                    break;
                case 7:
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ THANK YOU ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Option! Please choose correctly.");
            }
        }
    }
}


