package com.example.jsp.model.vo;

import java.util.Date;
import java.util.Objects;

public class VoFornecedor {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String descricao;
    private Date dtCadastro;

    public VoFornecedor() {
    }

    public VoFornecedor(Long id, String nome, String email, String telefone,
                        String descricao, Date dtCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.descricao = descricao;
        this.dtCadastro = dtCadastro;
    }

    
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(int id){
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        final VoFornecedor other = (VoFornecedor) obj;

        return Objects.equals(this.id, other.id);
    }
}
