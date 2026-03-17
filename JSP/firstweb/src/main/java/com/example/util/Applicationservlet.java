package com.example.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@webservlet("/")

public class Applicationservlet extends HttpServlet {

    public Applicationservlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        super.doGet(req, resp);

        String action = req.getServletPath(); // / ,/ services , /about

        switch (action) {
            case "/services":
                showservices(req,resp);
                
                break;
        
            default:  // loads first when the page appear
            showhome(req,resp);
                break;
        }
    }

    private void showhome(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req,resp);
    }

    private void showservices(HttpServletRequest req, HttpServletResponse resp) {

         RequestDispatcher dispatcher = req.getRequestDispatcher("home/servicesjsp");
        dispatcher.forward(req,resp);
        
    }

}
