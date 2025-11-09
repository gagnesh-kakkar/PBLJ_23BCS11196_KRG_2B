package PBLJ.Experiments.EXPERIMENT_7;

import java.sql.*;
import java.util.Scanner;

class ProductCRUD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "root";
        String pass = "your_password";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             Scanner sc = new Scanner(System.in)) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con.setAutoCommit(false); // Enable manual transaction control
            int choice;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1: // INSERT
                        System.out.print("Enter ProductID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();

                        PreparedStatement insert = con.prepareStatement(
                                "INSERT INTO Product VALUES (?, ?, ?, ?)");
                        insert.setInt(1, id);
                        insert.setString(2, name);
                        insert.setDouble(3, price);
                        insert.setInt(4, qty);
                        insert.executeUpdate();
                        con.commit();
                        System.out.println("Product added successfully!");
                        break;

                    case 2: // SELECT
                        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Product");
                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("ProductID") + " | " +
                                            rs.getString("ProductName") + " | " +
                                            rs.getDouble("Price") + " | " +
                                            rs.getInt("Quantity"));
                        }
                        break;

                    case 3: // UPDATE
                        System.out.print("Enter ProductID to update: ");
                        int uID = sc.nextInt();
                        System.out.print("Enter new Price: ");
                        double newPrice = sc.nextDouble();

                        PreparedStatement update = con.prepareStatement(
                                "UPDATE Product SET Price=? WHERE ProductID=?");
                        update.setDouble(1, newPrice);
                        update.setInt(2, uID);
                        update.executeUpdate();
                        con.commit();
                        System.out.println("Product updated successfully!");
                        break;

                    case 4: // DELETE
                        System.out.print("Enter ProductID to delete: ");
                        int dID = sc.nextInt();

                        PreparedStatement delete = con.prepareStatement(
                                "DELETE FROM Product WHERE ProductID=?");
                        delete.setInt(1, dID);
                        delete.executeUpdate();
                        con.commit();
                        System.out.println("Product deleted successfully!");
                        break;
                }
            } while (choice != 5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
