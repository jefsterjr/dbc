package org.dbc.ticketLog.controller.service;

import org.dbc.ticketLog.model.dto.CidadeDTO;

import java.util.List;

public interface CidadeService {

    CidadeDTO getCidadeById(Long id);

    List<CidadeDTO> getAll(String nome, Long idEstado);

    CidadeDTO save(CidadeDTO cidadeDTO);

    void delete(Long id);

    void save(List<CidadeDTO> cidadeDTO);
}
