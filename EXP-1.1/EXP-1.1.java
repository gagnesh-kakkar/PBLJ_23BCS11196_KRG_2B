import java.util.Scanner;

                            /*EASY LEVEL*/
class StringAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int vowels = 0, consonants = 0, digits = 0, specialChars = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (!Character.isWhitespace(ch)) {
                specialChars++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + specialChars);

    }
}

                         /*MEDIUM LEVEL*/
class MatrixOperations {

    public static int[][] readMatrix(Scanner sc, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements (" + rows + "x" + cols + "):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] add(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public static int[][] subtract(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int rowsA = A.length, colsA = A[0].length, colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns of Matrix A: ");
        int rowsA = sc.nextInt(), colsA = sc.nextInt();
        int[][] A = readMatrix(sc, rowsA, colsA);

        System.out.print("Enter rows and columns of Matrix B: ");
        int rowsB = sc.nextInt(), colsB = sc.nextInt();
        int[][] B = readMatrix(sc, rowsB, colsB);

        System.out.println("\nMatrix A:");
        displayMatrix(A);
        System.out.println("Matrix B:");
        displayMatrix(B);

        if (rowsA == rowsB && colsA == colsB) {
            System.out.println("\nAddition:");
            displayMatrix(add(A, B));

            System.out.println("Subtraction:");
            displayMatrix(subtract(A, B));
        } else {
            System.out.println("\nAddition and Subtraction not possible (dimension mismatch).");
        }

        if (colsA == rowsB) {
            System.out.println("\nMultiplication:");
            displayMatrix(multiply(A, B));
        } else {
            System.out.println("\nMultiplication not possible (Matrix A columns != Matrix B rows).");
        }

    }
}

                                    /*HARD LEVEL*/
class BankAccount {
    private String name;
    private String accountNumber;
    private double balance;

    public BankAccount(String name, String accountNumber, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Current Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Error: Insufficient funds. Current Balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! Current Balance: " + balance);
        }
    }

    public void displayInfo() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Create New Account ===");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(name, accountNumber, initialBalance);
        account.displayInfo();

        int choice;
        do {
            System.out.println("\n=== Banking Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account Info");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = sc.nextDouble();
                    account.deposit(depositAmt);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = sc.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;
                case 3:
                    account.displayInfo();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }
}