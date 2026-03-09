import java.sql.*;

public class FetchData {

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/testdb1";

        try {

            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create Connectionclear

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/company",
                    "root",
                    "123456");

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Execute Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            // 5. Fetch Data
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int salary = rs.getInt("salary");

                System.out.println(id + " " + name + " " + salary );
            }

            // 6. Close Connection
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}

