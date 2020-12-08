package org.dbc.ticketLog.model.dto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EstadoDTO {

    private Long id;
    private String nome;
    private String uf;
    private Long populacao;
    private byte[] bandeira;

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


    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public byte[] getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) throws IOException {
        if (bandeira != null) this.bandeira = Files.readAllBytes(Paths.get(bandeira));
    }
}
