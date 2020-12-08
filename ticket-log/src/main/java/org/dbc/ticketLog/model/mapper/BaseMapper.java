package org.dbc.ticketLog.model.mapper;

import java.util.List;

public interface BaseMapper<E, DTO> {
    DTO toDTO(E entity);

    E toEntity(DTO dto);

    List<DTO> toDTO(List<E> e);

    List<E> toEntity(List<DTO> dto);

//    E map(DTO dto, @MappingTarget E entity);
}
