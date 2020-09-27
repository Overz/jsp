package com.example.jsp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestControl extends HttpServlet {

	protected abstract void processRequest() throws ServletException, IOException;

	protected abstract void carregarAlterar();

	protected abstract void excluir();

	protected abstract void salvar();

	protected abstract void consultar();

	protected abstract void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;

	protected abstract void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
