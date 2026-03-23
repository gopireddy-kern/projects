package com.example.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.util.DBConnection;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) {

        int id = Integer.parseInt(req.getParameter("id"));

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM books WHERE book_id=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            res.sendRedirect("jsp/viewBooks.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
