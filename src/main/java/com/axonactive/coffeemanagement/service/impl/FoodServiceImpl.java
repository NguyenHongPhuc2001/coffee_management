package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.controller.request.FoodRequest;
import com.axonactive.coffeemanagement.dao.FoodDao;
import com.axonactive.coffeemanagement.service.FoodService;
import com.axonactive.coffeemanagement.service.dto.FoodDto;
import com.axonactive.coffeemanagement.service.mapper.FoodMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class FoodServiceImpl implements FoodService {
    @Inject
    private FoodDao foodDao;

    @Inject
    private FoodMapper foodMapper;

    @Override
    public FoodDto findById(Long foodId) {
        return foodMapper.toDto(foodDao.findById(foodId));
    }

    @Override
    public List<FoodDto> findAll() {
        return foodMapper.toDtos(foodDao.findAll());
    }

    @Override
    public FoodDto create(FoodRequest foodRequest) {
        return foodMapper.toDto(foodDao.create(foodRequest));
    }

    @Override
    public FoodDto update(FoodRequest foodRequest, Long foodId) {
        return foodMapper.toDto(foodDao.update(foodRequest, foodId));
    }

    @Override
    public void delete(Long foodId) {
        foodDao.delete(foodId);
    }

    @Override
    public List<FoodDto> findByCategoryId(Long categoryId) {
        return foodMapper.toDtos(foodDao.findByCategoryId(categoryId));
    }

    @Override
    public List<FoodDto> findByName(String name) {
        return foodMapper.toDtos(foodDao.findByName(name));
    }

    @Override
    public List<FoodDto> findByCurrentPriceBetween(Double startPrice, Double endPrice) {
        return foodMapper.toDtos(foodDao.findByCurrentPriceBetween(startPrice, endPrice));
    }

    @Override
    public List<FoodDto> findByCurrentPriceBetweenAndCategory(Double startPrice, Double endPrice, Long categoryId) {
        return foodMapper.toDtos(foodDao.findByCurrentPriceBetweenAndCategory(startPrice, endPrice, categoryId));
    }
}
