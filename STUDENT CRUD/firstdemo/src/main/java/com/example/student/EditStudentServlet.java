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

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

@Override
@SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

    String sid = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        // Validate inputs
        if (sid == null || sid.isEmpty() ||
            name == null || name.isEmpty() ||
            email == null || email.isEmpty() ||
            course == null || course.isEmpty()) {

            response.getWriter().println("All fields are required");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(sid);
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid Student ID format");
            return;
        }

        String sql = "UPDATE students SET name=?, email=?, course=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                response.sendRedirect(request.getContextPath() +"/viewStudents.jsp");
            } else {
                response.getWriter().println("Student not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }
}