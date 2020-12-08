package org.dbc.ticketLog.model.repository;

import org.dbc.ticketLog.model.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CidadeCustomRepository  {

    List<Cidade> getAllByNomeAndEstado(String nome, Long idEstado);
}
