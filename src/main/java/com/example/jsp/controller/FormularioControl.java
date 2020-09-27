package com.example.jsp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Formulario", urlPatterns = { "/testeFormulario" })
public class FormularioControl extends HttpServlet {


	protected void processarRequisicao(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		System.out.println("E-mail: " + req.getParameter("email"));
		System.out.println("Senha: " + req.getParameter("senha"));
		System.out.println("Cadastro: " + req.getParameter("cadastro"));
		System.out.println("Sexo: " + req.getParameter("sexo"));
		System.out.println("Linguagens Conhecidas");

		String[] nomes = req.getParameterValues("linguagens");
		for (String linguagem : nomes) {
			System.out.println(linguagem);
		}

		res.sendRedirect("formulario.jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		processarRequisicao(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		processarRequisicao(req, res);
	}
}
