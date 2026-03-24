package com.example.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.EmployeeDAO;
import com.example.model.EmployeeJavaBean;

@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        EmployeeJavaBean e = new EmployeeJavaBean();
        e.setEmpId(Integer.parseInt(req.getParameter("id")));
        e.setEmpName(req.getParameter("name"));
        e.setDepartment(req.getParameter("dept"));
        e.setSalary(Double.parseDouble(req.getParameter("salary")));

        new EmployeeDAO().update(e);
        res.sendRedirect("list");
    }
}
