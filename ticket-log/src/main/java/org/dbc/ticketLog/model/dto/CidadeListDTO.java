package org.dbc.ticketLog.model.dto;

import java.math.BigInteger;

public class CidadeListDTO {

    private Long id;
    private String nome;
    private BigInteger populacao;
    private String estado;

    public CidadeListDTO(Long id, String nome, BigInteger populacao, String estado) {
        this.id = id;
        this.nome = nome;
        this.populacao = populacao;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        if (nome != null) return nome.toUpperCase();
        return null;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigInteger getPopulacao() {
        return populacao;
    }

    public void setPopulacao(BigInteger populacao) {
        this.populacao = populacao;
    }
}
