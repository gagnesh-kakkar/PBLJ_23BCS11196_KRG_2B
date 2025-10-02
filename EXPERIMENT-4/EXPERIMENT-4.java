package PBLJ.Experiments;

                                    /*EASY LEVEL*/
import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID=" + id + ", Name=" + name + ", Salary=" + salary;
    }
}

class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        int choice;
        do {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee by ID");
            System.out.println("3. Remove Employee by ID");
            System.out.println("4. Search Employee by ID");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    employees.add(new Employee(id, name, salary));
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = sc.nextInt();
                    boolean foundUpdate = false;
                    for (Employee emp : employees) {
                        if (emp.id == updateId) {
                            sc.nextLine();
                            System.out.print("Enter new Name: ");
                            emp.name = sc.nextLine();
                            System.out.print("Enter new Salary: ");
                            emp.salary = sc.nextDouble();
                            System.out.println("Employee updated successfully!");
                            foundUpdate = true;
                            break;
                        }
                    }
                    if (!foundUpdate) {
                        System.out.println("Employee with ID " + updateId + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = sc.nextInt();
                    boolean removed = employees.removeIf(emp -> emp.id == removeId);
                    if (removed) {
                        System.out.println("Employee removed successfully!");
                    } else {
                        System.out.println("Employee with ID " + removeId + " not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    boolean foundSearch = false;
                    for (Employee emp : employees) {
                        if (emp.id == searchId) {
                            System.out.println("Employee Found: " + emp);
                            foundSearch = true;
                            break;
                        }
                    }
                    if (!foundSearch) {
                        System.out.println("Employee with ID " + searchId + " not found.");
                    }
                    break;

                case 5:
                    System.out.println("\n=== Employee List ===");
                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        for (Employee emp : employees) {
                            System.out.println(emp);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}


                                            /*MEDIUM LEVEL*/
class Card {
    String symbol;
    int number;

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    @Override
    public String toString() {
        return symbol + " - " + number;
    }
}

class CardCollectionSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, ArrayList<Card>> cardMap = new HashMap<>();

        addCard(cardMap, new Card("Spade", 1));
        addCard(cardMap, new Card("Spade", 3));
        addCard(cardMap, new Card("Spade", 10));
        addCard(cardMap, new Card("Heart", 2));
        addCard(cardMap, new Card("Heart", 5));
        addCard(cardMap, new Card("Diamond", 7));

        System.out.print("Enter symbol: ");
        String searchSymbol = sc.nextLine();

        if (cardMap.containsKey(searchSymbol)) {
            System.out.println("Cards with symbol '" + searchSymbol + "':");
            for (Card c : cardMap.get(searchSymbol)) {
                System.out.println(c);
            }
        } else {
            System.out.println("No cards found with symbol '" + searchSymbol + "'");
        }

        sc.close();
    }

    private static void addCard(HashMap<String, ArrayList<Card>> cardMap, Card card) {
        cardMap.putIfAbsent(card.symbol, new ArrayList<>());
        cardMap.get(card.symbol).add(card);
    }
}

                                            /*HARD LEVEL*/
class TicketBooking {
    private boolean isBooked = false;

    public synchronized void bookTicket(String userType) {
        if (!isBooked) {
            System.out.println(userType + " booked Seat 1");
            isBooked = true;
        } else {
            System.out.println(userType + " could not book. Seat already booked.");
        }
    }
}

class Customer extends Thread {
    private TicketBooking ticketBooking;
    private String userType;

    public Customer(TicketBooking ticketBooking, String userType) {
        this.ticketBooking = ticketBooking;
        this.userType = userType;
    }

    @Override
    public void run() {
        ticketBooking.bookTicket(userType);
    }
}

class TicketBookingSystem {
    public static void main(String[] args) {
        TicketBooking ticketBooking = new TicketBooking();


        Customer normalUser = new Customer(ticketBooking, "Normal Thread");

        Customer vipUser = new Customer(ticketBooking, "VIP Thread");

        normalUser.setPriority(Thread.MIN_PRIORITY);
        vipUser.setPriority(Thread.MAX_PRIORITY);

        normalUser.start();
        vipUser.start();
    }
}

