package com.example.jsp.controller;

import com.example.jsp.model.dao.DaoLivro;
import com.example.jsp.model.dao.DaoProduto;
import com.example.jsp.model.vo.VoLivro;
import com.example.jsp.model.vo.VoProduto;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LivroControl", urlPatterns = { "/crud_livro" })
public class LivroControl extends RequestControl {

	private HttpServletRequest req;
	private HttpServletResponse res;
	private RequestDispatcher rd;

	@Override
	protected void processRequest() throws ServletException, IOException {
		switch (req.getParameter("cmd")) {
			case "pesquisarPorNome" -> consultar();
			case "salvar" -> salvar();
			case "excluir" -> excluir();
			case "carregar" -> alterar();
		}
		rd.forward(req, res);
	}

	@Override
	protected void alterar() {
		Long id = Long.parseLong(req.getParameter("idTela"));
		try {
			VoLivro p = new DaoLivro().consultarPorId(id);
			req.setAttribute("produto", p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
			req.setAttribute("msgErro", "erro ao pesquisar por id " + e.getMessage());
		}
		rd = req.getRequestDispatcher("logado/novoLivro.jsp");
	}

	@Override
	protected void salvar() {
		VoLivro l = new VoLivro();
		String id = req.getParameter("id");
		l.setNome(req.getParameter("nome"));
		l.setAutor(req.getParameter("autor"));
		l.setEditora(req.getParameter("editora"));
		l.setAnoEdicao(req.getParameter("anoEdicao"));
		l.setDescricao(req.getParameter("descricao"));
		try {
			DaoLivro dao = new DaoLivro();
			if (id != null && !id.isEmpty()) {
				l.setId(id);
				dao.alterar(l);
				req.setAttribute("msgSucesso", "Alterado com Sucesso!");
			} else {
				dao.cadastrar(l);
				req.setAttribute("msgSucesso", "Salvo com Sucesso!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
			req.setAttribute("msgErro", "Erro ao excluir!");
		}
		rd = req.getRequestDispatcher("logado/novoLivro.jsp");
	}

	@Override
	public void excluir() {
		Long id = Long.parseLong(req.getParameter("idTela"));
		try {
			new DaoLivro().excluirPorID(id);
			req.setAttribute("msgSucesso", "Excluído com sucesso!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
			req.setAttribute("msgErro", "Erro ao excluir!");
		}
		rd = req.getRequestDispatcher("logado/livro.jsp");
	}

	@Override
	protected void consultar() {
		String nome = req.getParameter("nome");
		try {
			List<VoLivro> list = new DaoLivro().consultar(nome);
			if (list == null || list.isEmpty()) {
				req.setAttribute("msgAlerta", "Não foi encontrado nenhum registro com esse valor!");
				req.setAttribute("livro", null);
			}
			req.setAttribute("livro", list);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
			req.setAttribute("msgErro", "Erro ao pesquisar " + e.getMessage());
		}
		rd = req.getRequestDispatcher("logado/livro.jsp");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.req = request;
		this.res = response;
		this.processRequest();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.req = request;
		this.res = response;
		this.processRequest();
	}

}
