package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Promotion;
import com.axonactive.coffeemanagement.service.dto.PromotionDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PromotionMapper {
    PromotionDto toDto(Promotion promotion);
    List<PromotionDto> toDtos(List<Promotion> promotionList);
}
