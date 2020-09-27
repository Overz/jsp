package com.example.jsp.controller;

import com.example.jsp.model.dao.DaoProduto;
import com.example.jsp.model.vo.VoProduto;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TesteControl", urlPatterns = { "/crud_produto" })
public class Teste extends RequestControl {

	private HttpServletRequest req;
	private HttpServletResponse res;
	private RequestDispatcher rd;

	@Override
	protected void processRequest() throws ServletException, IOException {
		switch (req.getParameter("cmd")) {
			case "pesquisarPorNome" -> consultar();
			case "salvar" -> salvar();
			case "excluir" -> excluir();
			case "carregar" -> carregarAlterar();
		}
		rd.forward(req, res);
	}

	@Override
	protected void carregarAlterar() {
		Long id = Long.parseLong(req.getParameter("idTela"));
		try {
			VoProduto p = new DaoProduto().consultarPorId(id);
			req.setAttribute("produto", p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
			req.setAttribute("msgErro", "erro ao pesquisar por id " + e.getMessage());
		}
		rd = req.getRequestDispatcher("logado/novoProduto.jsp");
	}

	@Override
	protected void salvar() {
		VoProduto p = new VoProduto();
		String id = req.getParameter("id");
		p.setNome(req.getParameter("nome"));
		p.setPreco(req.getParameter("preco"));
		p.setEstoque(req.getParameter("estoque"));
		p.setDescricao(req.getParameter("descricao"));
		try {
			DaoProduto dao = new DaoProduto();
			if (id != null && !id.isEmpty()) {
				p.setId(id);
				dao.alterar(p);
				req.setAttribute("msgSucesso", "Alterado com Sucesso!");
			} else {
				List<VoProduto> list = dao.consultarTodos();
				p.setCodigo(this.addCodigo(list));
				dao.cadastrar(p);
				req.setAttribute("msgSucesso", "Salvo com Sucesso!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
		}
		rd = req.getRequestDispatcher("logado/novoProduto.jsp");
	}

	@Override
	public void excluir() {
		Long id = Long.parseLong(req.getParameter("idTela"));
		try {
			new DaoProduto().excluirPorID(id);
			req.setAttribute("msgSucesso", "Excluído com sucesso!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
			req.setAttribute("msgErro", "Erro ao excluir!");
		}
		rd = req.getRequestDispatcher("logado/produto.jsp");
	}

	@Override
	protected void consultar() {
		String nome = req.getParameter("nome");
		try {
			List<VoProduto> list = new DaoProduto().consultar(nome);
			if (list == null || list.isEmpty()) {
				req.setAttribute("msgAlerta", "Não foi encontrado nenhum registro com esse valor!");
				req.setAttribute("produto", null);
			}
			req.setAttribute("produto", list);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
			req.setAttribute("msgErro", "Erro ao pesquisar " + e.getMessage());
		}
		rd = req.getRequestDispatcher("logado/produto.jsp");
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

	private String addCodigo(List<VoProduto> list) {
		String year = String.valueOf(LocalDateTime.now().getYear());
		Long id = list.get(list.size() - 1).getId() + 1;
		return id + year;
	}

}
