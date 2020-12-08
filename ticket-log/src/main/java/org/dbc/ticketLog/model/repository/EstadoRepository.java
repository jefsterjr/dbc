package org.dbc.ticketLog.model.repository;

import org.dbc.ticketLog.model.Estado;
import org.dbc.ticketLog.model.dto.EstadoListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Query("SELECT new org.dbc.ticketLog.model.dto.EstadoListDTO(e.id, e.nome, e.uf, sum(c.populacao), e.bandeira) FROM Estado e INNER JOIN e.cidades c group by e order by e.id")
    List<EstadoListDTO> findEstadoSumPopulacao();

    @Query("SELECT new org.dbc.ticketLog.model.dto.EstadoListDTO(e.id, e.nome, e.uf, e.bandeira) FROM Estado e INNER JOIN e.cidades c group by e order by e.id")
    List<EstadoListDTO> findEstado();

}

