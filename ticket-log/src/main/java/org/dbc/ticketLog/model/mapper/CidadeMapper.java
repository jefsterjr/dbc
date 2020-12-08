package org.dbc.ticketLog.model.mapper;

import org.dbc.ticketLog.model.Cidade;
import org.dbc.ticketLog.model.dto.CidadeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CidadeMapper extends BaseMapper<Cidade, CidadeDTO> {
}
