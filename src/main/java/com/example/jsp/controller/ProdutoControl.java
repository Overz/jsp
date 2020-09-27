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

@WebServlet(name = "ProdutoControle", urlPatterns = { "/crud_produto" })
public class ProdutoControl extends RequestControl {

	private HttpServletRequest req;
	private HttpServletResponse res;
	private RequestDispatcher rd;

	protected ProdutoControl(){
	};

	@Override
	protected void processRequest() throws ServletException, IOException {
		switch (req.getParameter("cmd")) {
			case "pesquisarPorNome" -> this.consultar();
			case "salvar" -> this.salvar();
			case "excluir" -> this.excluir();
			case "carregar" -> this.carregarAlterar();
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
		VoProduto produto = new VoProduto();
		String id = req.getParameter("id");
		produto.setNome(req.getParameter("nome"));
		produto.setPreco(req.getParameter("preco"));
		produto.setEstoque(req.getParameter("estoque"));
		produto.setCodigo(id + 1 + LocalDateTime.now().getYear());

		try {
			DaoProduto dao = new DaoProduto();
			if (id != null) {
				produto.setId(id);
				dao.alterar(produto);
				req.setAttribute("msgSucesso", "Alterado com Sucesso!");
			} else {
				dao.cadastrar(produto);
				req.setAttribute("msgSucesso", "Salvo com Sucesso!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
		}
		rd = req.getRequestDispatcher("logado/novoProduto.jsp");
	}

	@Override
	protected void excluir() {
		Long id = Long.parseLong(req.getParameter("id"));
		try {
			new DaoProduto().excluirPorID(id);
			req.setAttribute("msgSucesso", "Excluido com Sucesso!");
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
				req.setAttribute("msgAlerta", "Não foi encontrado nenhum Produto!");
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
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.req = req;
		this.res = res;
		this.processRequest();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.req = req;
		this.res = res;
		this.processRequest();
	}

}
