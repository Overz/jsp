package com.example.jsp.model.vo;

import java.util.Date;

public class VoFornecedor {

	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private Date dtCadastro;

	public VoFornecedor(Long id, String nome, String email, String descricao, Date dtCadastro) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dtCadastro = dtCadastro;
	}

	public VoFornecedor() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
}
