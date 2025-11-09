package PBLJ.Experiments.EXPERIMENT_7;

import java.sql.*;

class FetchEmployees {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "root";
        String pass = "your_password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, pass);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EmpID, Name, Salary FROM Employee");

            while (rs.next()) {
                System.out.println("EmpID: " + rs.getInt("EmpID") +
                        ", Name: " + rs.getString("Name") +
                        ", Salary: " + rs.getDouble("Salary"));
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
