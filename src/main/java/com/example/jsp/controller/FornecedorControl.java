package com.example.jsp.controller;

import com.example.jsp.model.dao.DaoFornecedor;
import com.example.jsp.model.vo.VoFornecedor;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FornecedorControle", urlPatterns = { "/crud_fornecedor" })
public class FornecedorControl extends RequestControl {

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
			VoFornecedor f = new DaoFornecedor().consultarPorId(id);
			req.setAttribute("fornecedor", f);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
			req.setAttribute("msgErro", "erro ao pesquisar por id " + e.getMessage());
		}
		rd = req.getRequestDispatcher("logado/novoFornecedor.jsp");
	}

	@Override
	protected void salvar() {
		VoFornecedor voFornecedor = new VoFornecedor();
		String id = req.getParameter("id");
		voFornecedor.setNome(req.getParameter("nome"));
		voFornecedor.setEmail(req.getParameter("email"));
		voFornecedor.setTelefone(req.getParameter("telefone"));
		voFornecedor.setDescricao(req.getParameter("descricao"));
		try {
			DaoFornecedor fornecedorDao = new DaoFornecedor();
			if (id != null && !id.isEmpty()) {
				voFornecedor.setId(Long.parseLong(id));
				fornecedorDao.alterar(voFornecedor);
				req.setAttribute("msgSucesso", "Alterado com sucesso!");
			} else {
				voFornecedor.setDtCadastro(new Date());
				fornecedorDao.cadastrar(voFornecedor);
				req.setAttribute("msgSucesso", "Salvo com sucesso!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
			req.setAttribute("msgErro", "Erro ao Salvar!");
		}
		rd = req.getRequestDispatcher("logado/novoFornecedor.jsp");
	}

	@Override
	public void excluir() {
		Long id = Long.parseLong(req.getParameter("idTela"));
		try {
			new DaoFornecedor().excluirPorID(id);
			req.setAttribute("msgSucesso", "Excluído com sucesso!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
			req.setAttribute("msgErro", "Erro ao excluir!");
		}
		rd = req.getRequestDispatcher("logado/fornecedor.jsp");
	}

	@Override
	protected void consultar() {
		String nome = req.getParameter("nome");
		try {
			List<VoFornecedor> list = new DaoFornecedor().consultar(nome);
			if (list == null || list.isEmpty()) {
				req.setAttribute("msgAlerta", "Não foi encontrado nenhum registro com esse valor!");
				req.setAttribute("fornecedores", null);
			}
			req.setAttribute("fornecedor", list);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
			req.setAttribute("msgErro", "Erro ao pesquisar " + e.getMessage());
		}
		rd = req.getRequestDispatcher("logado/fornecedor.jsp");
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
