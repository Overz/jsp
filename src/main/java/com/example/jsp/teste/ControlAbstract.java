package com.example.jsp.teste;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ControlAbstract<C, D> extends HttpServlet {

	protected HttpServletRequest req;
	protected HttpServletResponse res;
	protected C c;
	protected D d;

	protected void request() {
		switch (req.getParameter("cmd")) {
			case RequestType.SALVAR -> salvar();
			case RequestType.CONSULTAR -> consultar();
			case RequestType.EXCLUIR -> excluir();
			case RequestType.CARREGAR -> carregar();
		}
	}

	protected void initClass(C c, D d) {
		this.c = c;
		this.d = d;
	}

	protected void salvar() {

	}

	protected void consultar() {
	}


	protected void excluir() {
	}


	protected void carregar() {
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		this.req = req;
		this.res = resp;
		this.request();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		this.req = req;
		this.res = resp;
		this.request();
	}
}

