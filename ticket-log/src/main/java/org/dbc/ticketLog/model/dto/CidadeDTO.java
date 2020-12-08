package org.dbc.ticketLog.model.dto;

import java.math.BigInteger;

public class CidadeDTO {

    private Long id;
    private String nome;
    private BigInteger populacao;
    private EstadoDTO estado;

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

    public EstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }

    public BigInteger getPopulacao() {
        return populacao;
    }

    public void setPopulacao(BigInteger populacao) {
        this.populacao = populacao;
    }
}
