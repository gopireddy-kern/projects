package com.example.student;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    @Override
    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String course = request.getParameter("course");


               // Input validation
        if (name == null || name.isEmpty() ||
            email == null || email.isEmpty() ||
            course == null || course.isEmpty()) {

            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "All fields are required.");
            return;
        }

        String sql = "INSERT INTO students(name,email,course) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

        

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);

            ps.executeUpdate();

             response.sendRedirect(request.getContextPath() + "/viewStudents.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }
}

           