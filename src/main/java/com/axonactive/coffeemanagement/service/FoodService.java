package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.controller.request.FoodRequest;
import com.axonactive.coffeemanagement.service.dto.FoodDto;

import java.util.List;

public interface FoodService {
    FoodDto findById(Long foodId);
    List<FoodDto> findAll();
    FoodDto create(FoodRequest foodRequest);
    FoodDto update(FoodRequest foodRequest, Long foodId);
    void delete(Long foodId);
    List<FoodDto> findByCategoryId(Long categoryId);
    List<FoodDto> findByName(String name);
    List<FoodDto> findByCurrentPriceBetween(Double startPrice, Double endPrice);
    List<FoodDto> findByCurrentPriceBetweenAndCategory(Double startPrice, Double endPrice, Long categoryId);

}
