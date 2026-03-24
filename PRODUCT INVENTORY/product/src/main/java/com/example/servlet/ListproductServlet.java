package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.productDAO;


@WebServlet("/listProduct")
public class ListproductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

                 productDAO dao = new productDAO();

        req.setAttribute("products", dao.getAll());
        
        req.getRequestDispatcher("jsp/viewProducts.jsp")
           .forward(req, res);
    }
}
