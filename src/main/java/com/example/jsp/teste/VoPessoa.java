package com.example.jsp.teste;

import java.io.Serializable;

public class VoPessoa implements Serializable {

	private int id;
	private String email;
	private String nome;
	private String telefone;

	public VoPessoa() {
	}

	public VoPessoa(String email, String nome, String telefone) {
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "VoPessoa{" +
		       "id=" + id +
		       ", email='" + email + '\'' +
		       ", nome='" + nome + '\'' +
		       ", telefone='" + telefone + '\'' +
		       '}';
	}
}
