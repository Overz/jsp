package com.example.jsp.model.vo;

import java.util.Objects;

public class VoProduto {

	private Long id;
	private String nome;
	private double preco;
	private int estoque;
	private String codigo;
	private String descricao;

	public VoProduto() {
	}

	public VoProduto(String nome, double preco, int estoque, String codigo) {
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
		this.codigo = codigo;
	}

	public VoProduto(String nome, double preco, int estoque, String codigo, String descricao) {
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public VoProduto(Long id, String nome, double preco, int estoque, String codigo) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
		this.codigo = codigo;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(String id) {
		this.id = Long.valueOf(id);
	}

	public void setId(int id) {
		this.id = (long) id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setPreco(String preco) {
		this.preco = Double.parseDouble(preco);
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public void setEstoque(String estoque) {
		this.estoque = Integer.parseInt(estoque);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 37 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final VoProduto other = (VoProduto) obj;

		return Objects.equals(this.id, other.id);
	}
}
