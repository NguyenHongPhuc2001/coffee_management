package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.controller.request.DrinkRequest;
import com.axonactive.coffeemanagement.service.dto.DrinkDto;


import java.util.List;

public interface DrinkService {
    DrinkDto findById(Long drinkId);
    List<DrinkDto> findAll();
    DrinkDto create(DrinkRequest drinkRequest);
    DrinkDto update(DrinkRequest drinkRequest, Long drinkId);
    void delete(Long drinkId);
    List<DrinkDto> findByCategoryId(Long categoryId);
    List<DrinkDto> findByName(String name);
    List<DrinkDto> findByCurrentPriceBetween(Double startPrice, Double endPrice);
    List<DrinkDto> findByCurrentPriceBetweenAndCategory(Double startPrice, Double endPrice, Long categoryId);
}
