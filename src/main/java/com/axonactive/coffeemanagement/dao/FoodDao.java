package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.controller.request.FoodRequest;
import com.axonactive.coffeemanagement.entity.Food;

import java.util.List;

public interface FoodDao {
    Food findById(Long foodId);
    List<Food> findAll();
    Food create(FoodRequest foodRequest);
    Food update(FoodRequest foodRequest, Long foodId);
    void delete(Long foodId);
    List<Food> findByCategoryId(Long categoryId);
    List<Food> findByName(String name);
    List<Food> findByCurrentPriceBetween(Double startPrice, Double endPrice);
    List<Food> findByCurrentPriceBetweenAndCategory(Double startPrice, Double endPrice, Long categoryId);

}
