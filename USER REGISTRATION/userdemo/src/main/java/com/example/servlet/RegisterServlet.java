package com.example.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.util.DBConnection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO users(username,email,password) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);

            ps.executeUpdate();

            response.sendRedirect("jsp/login.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
