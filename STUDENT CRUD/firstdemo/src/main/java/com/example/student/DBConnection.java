package com.example.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/studentdb",
                    "root",
                    "123456"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}