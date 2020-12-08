package org.dbc.ticketLog.controller.service.impl;

import org.dbc.ticketLog.controller.service.ConsultaCotacaoService;
import org.dbc.ticketLog.controller.service.EstadoService;
import org.dbc.ticketLog.model.dto.EstadoDTO;
import org.dbc.ticketLog.model.dto.EstadoListDTO;
import org.dbc.ticketLog.model.mapper.EstadoMapper;
import org.dbc.ticketLog.model.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository repository;

    @Autowired
    private EstadoMapper mapper;


    @Value("${ticket-log.custo-populacional}")
    private BigDecimal custoPopulacional;

    @Value("${ticket-log.valor-corte}")
    private BigInteger valorCorte;

    @Value("${ticket-log.desconto}")
    private BigDecimal desconto;


    @Override
    public EstadoDTO getEstadoById(Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow());
    }

    @Override
    public List<EstadoListDTO> getAllCustoPopulacional() {
        List<EstadoListDTO> estados = repository.findEstadoSumPopulacao();
        final BigDecimal valorPopulacionalReais = custoPopulacional.multiply(ConsultaCotacaoService.getCotacaoDolar());

        estados.forEach(estadoListDTO -> calcularCustoPopulacional(valorPopulacionalReais, estadoListDTO));
        return estados;
    }
    @Override
    public List<EstadoListDTO> getAll() {
        return repository.findEstado();
    }

    private void calcularCustoPopulacional(BigDecimal valorPopulacionalReais, EstadoListDTO estadoListDTO) {
        final BigInteger cidadaosAcimaValorCorte = estadoListDTO.getPopulacao().subtract(valorCorte);
        if (cidadaosAcimaValorCorte.signum() == 1) {

            BigDecimal aux = desconto.divide(BigDecimal.valueOf(100))
                    .subtract(BigDecimal.ONE)
                    .multiply(BigDecimal.valueOf(-1));

            BigDecimal valorPopulacionalDesconto = valorPopulacionalReais.multiply(aux);

            estadoListDTO.setCustoPopulacional(valorPopulacionalDesconto.multiply(new BigDecimal(cidadaosAcimaValorCorte)));
            estadoListDTO.getCustoPopulacional().add(new BigDecimal(valorCorte).multiply(valorPopulacionalReais));
        } else {
            estadoListDTO.setCustoPopulacional(new BigDecimal(estadoListDTO.getPopulacao()).multiply(valorPopulacionalReais));
        }
    }

    @Override
    public EstadoDTO save(EstadoDTO estadoDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
