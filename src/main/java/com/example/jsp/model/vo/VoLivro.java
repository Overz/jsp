package com.example.jsp.model.vo;

public class VoLivro {

	private Long id;
	private String nome;
	private String autor;
	private String editora;
	private int anoEdicao;
	private String descricao;

	public VoLivro() {
	}

	public VoLivro(String nome, String autor, String editora, int anoEdicao, String descricao) {
		this.nome = nome;
		this.autor = autor;
		this.editora = editora;
		this.anoEdicao = anoEdicao;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(int id) {
		this.id = (long) id;
	}

	public void setId(String id) {
		this.id = Long.valueOf(id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getAnoEdicao() {
		return anoEdicao;
	}

	public void setAnoEdicao(int anoEdicao) {
		this.anoEdicao = anoEdicao;
	}

	public void setAnoEdicao(String anoEdicao) {
		try {
			this.anoEdicao = Integer.parseInt(anoEdicao.split("-")[ 0 ]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "VoLivro{" +
		       "id=" + id +
		       ", nome='" + nome + '\'' +
		       ", autor='" + autor + '\'' +
		       ", editora='" + editora + '\'' +
		       ", anoEdicao=" + anoEdicao +
		       ", descricao='" + descricao + '\'' +
		       '}';
	}
}
