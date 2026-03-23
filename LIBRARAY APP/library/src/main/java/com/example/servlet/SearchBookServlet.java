package com.example.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.util.DBConnection;

@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String title = req.getParameter("title");

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM books WHERE title LIKE ?"
            );

            ps.setString(1, "%" + title + "%");

            ResultSet rs = ps.executeQuery();

            req.setAttribute("result", rs);
            req.getRequestDispatcher("jsp/searchResult.jsp").forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
