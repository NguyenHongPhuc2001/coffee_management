package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.BarTable;
import com.axonactive.coffeemanagement.service.dto.BarTableDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface BarTableMapper {
    BarTableDto toDto(BarTable barTable);
    List<BarTableDto> toDtos(List<BarTable> barTableList);
}
