package org.dbc.ticketLog.model.repository.impl;

import org.dbc.ticketLog.model.Cidade;
import org.dbc.ticketLog.model.repository.CidadeCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CidadeCustomRepositoryImpl implements CidadeCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Cidade> getAllByNomeAndEstado(String nome, Long idEstado) {
        StringBuffer sql = new StringBuffer("select c.id, c.nome, c.populacao, e.id, e.nome, e.uf from ticket_log.cidade c " +
                "LEFT JOIN ticket_log.estado e on (c.estado_id = e.id)" +
                "where e.id is not null");
        if (nome != null) {
            sql.append(" and c.nome like ? ");
        } else if (idEstado != null) {
            sql.append(" and e.id = ? ");
        }
        sql.append(" ORDER BY c.id ");
        sql.append(" LIMIT 20");
        Query query = entityManager.createNativeQuery(sql.toString());
        if (nome != null) query.setParameter(1, nome);
        if (idEstado != null) query.setParameter(1, idEstado);


        return (List<Cidade>) query.getResultList();
    }
}
