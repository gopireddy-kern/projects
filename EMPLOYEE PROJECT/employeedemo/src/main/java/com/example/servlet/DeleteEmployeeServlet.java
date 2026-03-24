package com.example.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.EmployeeDAO;

@WebServlet("/delete")
public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            new EmployeeDAO().delete(id);
            res.sendRedirect("list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
      
