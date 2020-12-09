package org.dbc.ticketLog.model.repository.impl;

import org.dbc.ticketLog.model.Cidade;
import org.dbc.ticketLog.model.repository.CidadeCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CidadeRepositoryCustomÏmpl implements CidadeCustomRepository {

    @Autowired
    private EntityManager entityManager;

    private Query query;

    @Override
    public List<Cidade> findByFilter(String nome, Long estadoId) {
        int paramCount = 0;
        StringBuffer sql = new StringBuffer("SELECT c.id, c.nome, c.populacao, c.estado_id FROM cidade c where c.estado_id is not null ");
        if (nome != null) {
            paramCount++;
            sql.append(" c.nome like ?");
        }
        if (estadoId != null) {
            paramCount++;
            sql.append(" c.estado_id = ?");
        }
        query = entityManager.createNativeQuery(sql.toString());

        if (nome != null) query.setParameter(1, nome);
        if (estadoId != null) query.setParameter(paramCount, estadoId);


        return (List<Cidade>) query.getResultList();
    }
}
