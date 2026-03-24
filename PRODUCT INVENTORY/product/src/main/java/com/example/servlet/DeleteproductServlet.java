package com.example.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.productDAO;



@WebServlet("/deleteProduct")
public class DeleteproductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

                 try {
            String idStr = req.getParameter("id");

            if (idStr == null || idStr.isEmpty()) {
                res.sendRedirect("listProduct?error=Invalid ID");
                return;
            }

            int id = Integer.parseInt(idStr);

            productDAO dao = new productDAO();
            dao.delete(id);

            res.sendRedirect("listProduct");

        } catch (NumberFormatException e) {
            res.sendRedirect("listProduct?error=Invalid Number");
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("listProduct?error=Delete Failed");
        }
    }
}

        