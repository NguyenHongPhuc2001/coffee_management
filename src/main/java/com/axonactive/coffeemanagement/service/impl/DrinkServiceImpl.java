package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.controller.request.DrinkRequest;
import com.axonactive.coffeemanagement.dao.DrinkDao;
import com.axonactive.coffeemanagement.service.DrinkService;
import com.axonactive.coffeemanagement.service.dto.DrinkDto;
import com.axonactive.coffeemanagement.service.mapper.DrinkMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;


@Stateless
public class DrinkServiceImpl implements DrinkService {

    @Inject
    private DrinkDao drinkDao;

    @Inject
    private DrinkMapper drinkMapper;

    @Override
    public DrinkDto findById(Long drinkId) {
        return drinkMapper.toDto(drinkDao.findById(drinkId));
    }

    @Override
    public List<DrinkDto> findAll() {
        return drinkMapper.toDtos(drinkDao.findAll());
    }

    @Override
    public DrinkDto create(DrinkRequest drinkRequest) {
        return drinkMapper.toDto(drinkDao.create(drinkRequest));
    }

    @Override
    public DrinkDto update(DrinkRequest drinkRequest, Long drinkId) {
        return drinkMapper.toDto(drinkDao.update(drinkRequest, drinkId));
    }

    @Override
    public void delete(Long drinkId) {
        drinkDao.delete(drinkId);
    }

    @Override
    public List<DrinkDto> findByCategoryId(Long categoryId) {
        return drinkMapper.toDtos(drinkDao.findByCategoryId(categoryId));
    }

    @Override
    public List<DrinkDto> findByName(String name) {
        return drinkMapper.toDtos(drinkDao.findByName(name));
    }

    @Override
    public List<DrinkDto> findByCurrentPriceBetween(Double startPrice, Double endPrice) {
        return drinkMapper.toDtos(drinkDao.findByCurrentPriceBetween(startPrice, endPrice));
    }

    @Override
    public List<DrinkDto> findByCurrentPriceBetweenAndCategory(Double startPrice, Double endPrice, Long categoryId) {
        return drinkMapper.toDtos(drinkDao.findByCurrentPriceBetweenAndCategory(startPrice, endPrice, categoryId));
    }
}
