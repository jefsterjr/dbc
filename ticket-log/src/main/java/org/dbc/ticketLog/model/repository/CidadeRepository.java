package org.dbc.ticketLog.model.repository;

import org.dbc.ticketLog.model.Cidade;
import org.dbc.ticketLog.model.dto.CidadeListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("SELECT c FROM Cidade c LEFT JOIN Estado e where c.id = :id AND e.uf <> 'RS'")
    Optional<Cidade> verificarCidadeExclusao(@Param("id") Long id);

    @Query("SELECT c FROM Cidade as c LEFT OUTER JOIN c.estado as e where c.nome like :nome AND e.id = :idEstado")
    Cidade verificarNome(@Param("nome") String nome, @Param("idEstado") Long idEstado);

    @Query("DELETE FROM Cidade c where c.id = :id")
    void delete(@Param("id") Long id);

    @Query("SELECT new org.dbc.ticketLog.model.dto.CidadeListDTO(c.id, c.nome, c.populacao, e.nome) FROM Cidade c LEFT JOIN c.estado e where c.nome LIKE :nome")
    Page<CidadeListDTO> findAllByNomeIsLike(@Param("nome") String nome, Pageable pageable);
}
