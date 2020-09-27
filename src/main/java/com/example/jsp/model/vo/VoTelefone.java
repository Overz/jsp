package com.example.jsp.model.vo;

import java.util.Objects;

public class VoTelefone {
    private Long id;
    private String numero;
    private String ddd;
    private String operadora;
    private String contato;

    public VoTelefone() {
    }

    public VoTelefone(String numero, String ddd, String operadora, String contato) {
        this.numero = numero;
        this.ddd = ddd;
        this.operadora = operadora;
        this.contato = contato;
    }

    public VoTelefone(Long id, String numero, String ddd, String operadora, String contato) {
        this.id = id;
        this.numero = numero;
        this.ddd = ddd;
        this.operadora = operadora;
        this.contato = contato;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final VoTelefone other = (VoTelefone) obj;

        return Objects.equals(this.id, other.id);
    }
}
