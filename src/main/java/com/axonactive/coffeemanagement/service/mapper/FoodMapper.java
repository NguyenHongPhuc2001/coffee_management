package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Food;
import com.axonactive.coffeemanagement.service.dto.FoodDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface FoodMapper {
    FoodDto toDto(Food food);
    List<FoodDto> toDtos(List<Food> foodList);
}
