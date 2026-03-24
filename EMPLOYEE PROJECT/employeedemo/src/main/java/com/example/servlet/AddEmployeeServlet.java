package com.example.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.EmployeeDAO;
import com.example.model.EmployeeJavaBean;


@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        try {
        EmployeeJavaBean e = new EmployeeJavaBean();
        e.setEmpName(req.getParameter("name"));
        e.setDepartment(req.getParameter("dept"));
        e.setSalary(Double.parseDouble(req.getParameter("salary")));

        new EmployeeDAO().insert(e);
        res.sendRedirect("list");

         } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


    
