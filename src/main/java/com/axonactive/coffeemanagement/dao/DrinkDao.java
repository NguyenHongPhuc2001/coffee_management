package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.controller.request.DrinkRequest;
import com.axonactive.coffeemanagement.controller.request.FoodRequest;
import com.axonactive.coffeemanagement.entity.Drink;
import com.axonactive.coffeemanagement.entity.Food;

import java.util.List;

public interface DrinkDao {
    Drink findById(Long drinkId);
    List<Drink> findAll();
    Drink create(DrinkRequest drinkRequest);
    Drink update(DrinkRequest drinkRequest, Long drinkId);
    void delete(Long drinkId);
    List<Drink> findByCategoryId(Long categoryId);
    List<Drink> findByName(String name);
    List<Drink> findByCurrentPriceBetween(Double startPrice, Double endPrice);
    List<Drink> findByCurrentPriceBetweenAndCategory(Double startPrice, Double endPrice, Long categoryId);

}
