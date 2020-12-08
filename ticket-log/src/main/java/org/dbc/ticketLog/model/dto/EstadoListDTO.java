package org.dbc.ticketLog.model.dto;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EstadoListDTO {

    private Long id;
    private String nome;
    private String uf;
    private BigInteger populacao;
    private BigDecimal custoPopulacional;
    private byte[] bandeira;

    public EstadoListDTO(Long id, String nome, String uf, BigInteger populacao, String bandeira) throws IOException {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.populacao = populacao;
        this.bandeira = Files.readAllBytes(Paths.get(bandeira));
    }

    public EstadoListDTO(Long id, String nome, String uf, String bandeira) throws IOException {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.bandeira = Files.readAllBytes(Paths.get(bandeira));
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public BigInteger getPopulacao() {
        return populacao;
    }

    public void setPopulacao(BigInteger populacao) {
        this.populacao = populacao;
    }

    public byte[] getBandeira() {
        return bandeira;
    }

    public void setBandeira(byte[] bandeira) {
        this.bandeira = bandeira;
    }

    public BigDecimal getCustoPopulacional() {
        return custoPopulacional;
    }

    public void setCustoPopulacional(BigDecimal custoPopulacional) {
        this.custoPopulacional = custoPopulacional;
    }
}
