package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.controller.request.PromotionRequest;
import com.axonactive.coffeemanagement.entity.Promotion;

import java.util.Date;
import java.util.List;

public interface PromotionDao {
    Promotion findById(Long promotionId);
    List<Promotion> findAll();
    Promotion create(PromotionRequest promotionRequest);
    Promotion update(PromotionRequest promotionRequest, Long promotionId);
    void delete(Long promotionId);
    List<Promotion> findByNotExpired(Date toDay);

}
