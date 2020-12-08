package org.dbc.ticketLog.model.mapper;

import org.dbc.ticketLog.model.Estado;
import org.dbc.ticketLog.model.dto.EstadoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface EstadoMapper extends BaseMapper<Estado, EstadoDTO> {

}
