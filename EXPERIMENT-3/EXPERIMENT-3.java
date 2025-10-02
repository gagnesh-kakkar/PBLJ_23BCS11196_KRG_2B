package PBLJ.Experiments;
                                            /*EASY LEVEL*/
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            double number = sc.nextDouble();

            if (number < 0) {
                throw new IllegalArgumentException("Cannot calculate the square root of a negative number");
            }

            double result = Math.sqrt(number);
            System.out.println("Square root: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
                                                /*MEDIUM LEVEL*/

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int correctPIN = 1500;
        double balance = 3000;

        try {
            System.out.print("Enter PIN: ");
            int enteredPIN = sc.nextInt();

            if (enteredPIN != correctPIN) {
                throw new SecurityException("Invalid PIN entered!");
            }

            try {
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = sc.nextDouble();

                if (withdrawAmount > balance) {
                    throw new InsufficientBalanceException("Insufficient balance.");
                } else {
                    balance -= withdrawAmount;
                    System.out.println("Withdrawal successful! Amount withdrawn: " + withdrawAmount);
                }

            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Current Balance: " + balance);
            }

        } catch (SecurityException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Access Denied.");
        } finally {
            sc.close();
        }
    }
}
                                            /*HARD LEVEL*/

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    private String name;
    private String prerequisite;
    private int capacity;
    private List<String> enrolledStudents;

    public Course(String name, String prerequisite, int capacity) {
        this.name = name;
        this.prerequisite = prerequisite;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(String studentName, boolean prerequisiteCompleted)
            throws CourseFullException, PrerequisiteNotMetException {

        if (enrolledStudents.size() >= capacity) {
            throw new CourseFullException("Course is full. Cannot enroll " + studentName + " in " + name + ".");
        }

        if (!prerequisiteCompleted && prerequisite != null) {
            throw new PrerequisiteNotMetException(
                    "Complete " + prerequisite + " before enrolling in " + name + ".");
        }

        enrolledStudents.add(studentName);
        System.out.println("✅ " + studentName + " successfully enrolled in " + name + ".");
    }

    public void displayEnrolledStudents() {
        System.out.println("Enrolled students in " + name + ": " + enrolledStudents);
    }
}

class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Course advancedJava = new Course("Advanced Java", "Core Java", 2);

        try {
            advancedJava.enrollStudent("Gagnesh", false);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            advancedJava.enrollStudent("Jaidev", true);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            advancedJava.enrollStudent("Abhay", true);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            advancedJava.enrollStudent("Jatin", true);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }

        advancedJava.displayEnrolledStudents();
    }
}


