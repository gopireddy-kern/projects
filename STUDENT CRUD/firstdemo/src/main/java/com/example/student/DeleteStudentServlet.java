package com.example.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                response.setContentType("text/html;charset=UTF-8");
                response.setContentType("text/html;charset=UTF-8");


                 String sid = request.getParameter("id");
        if (sid == null || sid.isEmpty()) {
            response.getWriter().println("Invalid Student ID");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(sid);
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid Student ID format");
            return;
        }

        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                response.sendRedirect(request.getContextPath()+ "/viewStudent.jsp");
            } else {
                response.getWriter().println("Student not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }
}

       