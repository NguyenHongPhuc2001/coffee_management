package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.BillDetail;
import com.axonactive.coffeemanagement.service.dto.BillDetailDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface BillDetailMapper {
    BillDetailDto toDto(BillDetail billDetail);
    List<BillDetailDto> toDtos(List<BillDetail> billDetails);
}
