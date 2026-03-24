package com.example.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.productDAO;
import com.example.model.Product;

@WebServlet("/addProduct")
public class AddproductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

                 try {

            String name = req.getParameter("name");
            String priceStr = req.getParameter("price");
            String qtyStr = req.getParameter("quantity");
            String category = req.getParameter("category");

        
            if (name == null || name.isEmpty() ||
                priceStr == null || qtyStr == null) {

                res.sendRedirect("jsp/addProduct.jsp?error=Missing Fields");
                return;
            }

        
            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(qtyStr);

            
            Product p = new Product();
            p.setProductName(name);
            p.setPrice(price);
            p.setQuantity(quantity);
            p.setCategory(category);

        
            productDAO dao = new productDAO();
            dao.insert(p);

        
            res.sendRedirect("listProduct");

        } catch (NumberFormatException e) {
            res.sendRedirect("jsp/addProduct.jsp?error=Invalid Number Format");
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("jsp/addProduct.jsp?error=Something went wrong");
        }
    }
}




       
