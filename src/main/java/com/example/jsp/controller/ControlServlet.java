package com.example.jsp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import jdk.jfr.Description;

//@Description("Classe referente ao formulario do arquivo Form.jsp")
@WebServlet(name = "Control", urlPatterns = { "/requestMap" })
public class ControlServlet extends HttpServlet {

	public ControlServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		requestMapper(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		requestMapper(req, res);
	}

	protected void requestMapper(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String a = req.getParameter("name");
		String b = req.getParameter("whatsapp");

		System.out.println(a);
		System.out.println(b);
	}
}
