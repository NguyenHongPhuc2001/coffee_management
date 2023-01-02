package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Drink;
import com.axonactive.coffeemanagement.service.dto.DrinkDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface DrinkMapper {
    DrinkDto toDto(Drink drink);
    List<DrinkDto> toDtos(List<Drink> drinkList);
}
