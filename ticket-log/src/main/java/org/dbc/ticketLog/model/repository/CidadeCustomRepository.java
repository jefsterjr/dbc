package org.dbc.ticketLog.model.repository;

import org.dbc.ticketLog.model.Cidade;

import java.util.List;

public interface CidadeCustomRepository {
    List<Cidade> findByFilter(String nome, Long estadoId);
}
