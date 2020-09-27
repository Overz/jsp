package com.example.jsp.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmailControle", urlPatterns = {"/site_email"})
public class EmailControl extends HttpServlet {

    private HttpServletRequest req;
    private HttpServletResponse res;
    private RequestDispatcher rd;

    protected void processRequest()
            throws ServletException, IOException {
        System.out.println(req.getParameter("nome"));
        System.out.println(req.getParameter("assunto"));

        this.getServletContext().setAttribute("sucesso", "salvo com sucesso!");

        rd = req.getRequestDispatcher("formulario.jsp");
        rd.forward(req, res);
    }

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        this.req = req;
        this.res = res;
        this.processRequest();
    }

  
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        this.req = req;
        this.res = res;
        this.processRequest();
    }
}
