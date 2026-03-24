package com.example.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.productDAO;
import com.example.model.Product;

@WebServlet("/updateProduct")
public class UpdateproductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

                    try {
            String idStr = req.getParameter("id");
            String name = req.getParameter("name");
            String priceStr = req.getParameter("price");
            String qtyStr = req.getParameter("quantity");
            String category = req.getParameter("category");

    
            if (idStr == null || name == null || name.isEmpty()) {
                res.sendRedirect("jsp/editProduct.jsp?error=Missing Fields");
                return;
            }

            int id = Integer.parseInt(idStr);
            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(qtyStr);

    
            Product p = new Product();
            p.setProductId(id);
            p.setProductName(name);
            p.setPrice(price);
            p.setQuantity(quantity);
            p.setCategory(category);

            
            productDAO dao = new productDAO();
            dao.update(p);

        
            res.sendRedirect("listProduct");

        } catch (NumberFormatException e) {
            res.sendRedirect("jsp/editProduct.jsp?error=Invalid Number");
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("jsp/editProduct.jsp?error=Update Failed");
        }
    }
}

      