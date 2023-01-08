package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Bill;
import com.axonactive.coffeemanagement.service.dto.BillDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface BillMapper {
    BillDto toDto(Bill bill);
    List<BillDto> toDtos (List<Bill> bills);
}
