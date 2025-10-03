package PBLJ.Experiments;

import java.io.*;
import java.util.*;

                                    /*EASY LEVEL*/

class SumUsingWrapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numbers (comma separated): ");
        String input = sc.nextLine();

        String[] numbers = input.split(",");

        ArrayList<Integer> numList = new ArrayList<>();

        for (String num : numbers) {
            int value = Integer.parseInt(num.trim());
            numList.add(value);
        }

        int sum = 0;
        for (Integer n : numList) {
            sum += n;
        }

        System.out.println("Sum of numbers = " + sum);

        sc.close();
    }
}

                                    /*MEDIUM LEVEL*/

class StudentData implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    double gpa;

    public StudentData(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
    }
}

class StudentSerializationDemo {
    public static void main(String[] args) {
        String filename = "student.ser";

        StudentData student1 = new StudentData(101, "Alice", 9.1);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(student1);
            System.out.println("Student serialized successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            StudentData deserializedStudent = (StudentData) ois.readObject();
            System.out.println("\nStudent deserialized:");
            deserializedStudent.displayDetails();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Student class not found.");
        }
    }
}

                                        /*HARD LEVEL*/
class Employees {
    String name;
    int id;
    String designation;
    double salary;

    public Employees(String name, int id, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " | " + id + " | " + designation + " | " + salary;
    }
}

class EmployeeManagementApp {
    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Employee Management Menu ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("⚠ Invalid choice, please try again.");
            }
        } while (choice != 3);

        sc.close();
    }

    private static void addEmployee(Scanner sc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Designation: ");
            String designation = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            Employees emp = new Employees(name, id, designation, salary);
            writer.write(emp.toString());
            writer.newLine();

            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void displayEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n=== Employee List ===");
            boolean hasData = false;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                hasData = true;
            }
            if (!hasData) {
                System.out.println("No employees found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No employee records found. File does not exist yet.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}