package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.entity.Promotion;

public interface PromotionDao {
    Promotion findById(Long promotionId);
}
