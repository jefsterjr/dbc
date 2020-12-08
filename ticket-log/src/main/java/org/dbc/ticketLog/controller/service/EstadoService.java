package org.dbc.ticketLog.controller.service;

import org.dbc.ticketLog.model.dto.EstadoDTO;
import org.dbc.ticketLog.model.dto.EstadoListDTO;

import java.util.List;

public interface EstadoService {

    EstadoDTO getEstadoById(Long id);

    List<EstadoListDTO> getAllCustoPopulacional();

    List<EstadoListDTO> getAll();

    EstadoDTO save(EstadoDTO estadoDTO);

    void delete(Long id);
}
