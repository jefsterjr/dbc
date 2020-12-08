package org.dbc.ticketLog.controller.service.impl;

import org.dbc.ticketLog.controller.service.CidadeService;
import org.dbc.ticketLog.model.dto.CidadeDTO;
import org.dbc.ticketLog.model.exception.ExclusaoMunicipioException;
import org.dbc.ticketLog.model.exception.NomeMunicipioException;
import org.dbc.ticketLog.model.mapper.CidadeMapper;
import org.dbc.ticketLog.model.repository.CidadeCustomRepository;
import org.dbc.ticketLog.model.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository repository;

    @Autowired
    private CidadeCustomRepository customRepository;

    @Autowired
    private CidadeMapper mapper;

    @Override
    public CidadeDTO getCidadeById(Long id) {
        return mapper.toDTO(repository.getOne(id));
    }

    @Override
    public List<CidadeDTO> getAll(String nome, Long idEstado) {
        return mapper.toDTO(customRepository.getAllByNomeAndEstado(nome, idEstado));
    }

    @Override
    public CidadeDTO save(CidadeDTO cidadeDTO) {
        if (repository.verificarNome(cidadeDTO.getNome(), cidadeDTO.getEstado().getId()) != null)
            throw new NomeMunicipioException();
        return mapper.toDTO(repository.save(mapper.toEntity(cidadeDTO)));
    }

    @Override
    public void delete(Long id) {
        if (repository.verificarCidadeExclusao(id).isPresent()) throw new ExclusaoMunicipioException();
        repository.delete(id);

    }

    @Override
    public void save(List<CidadeDTO> cidadeDTOs) {
        repository.saveAll(mapper.toEntity(cidadeDTOs));
    }
}
