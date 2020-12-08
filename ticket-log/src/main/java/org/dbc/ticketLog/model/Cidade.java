package org.dbc.ticketLog.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Estado estado;

    private BigInteger populacao;

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public BigInteger getPopulacao() {
        return populacao;
    }

    public void setPopulacao(BigInteger populacao) {
        this.populacao = populacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cidade)) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(getId(), cidade.getId()) &&
                getNome().equals(cidade.getNome()) &&
                getEstado().equals(cidade.getEstado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getEstado());
    }
}
