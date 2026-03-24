package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.EmployeeDAO;
import com.example.model.EmployeeJavaBean;

@WebServlet("/list")
public class ListEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

                try {
            List<EmployeeJavaBean> list = new EmployeeDAO().getAll();
            req.setAttribute("list", list);
            req.getRequestDispatcher("jsp/list.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


      