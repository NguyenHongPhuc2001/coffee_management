package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.entity.Promotion;
import com.axonactive.coffeemanagement.service.dto.PromotionDto;

import java.util.List;

public interface PromotionDao {
    Promotion findById(Long promotionId);
    List<Promotion> findAll();
    Promotion create(PromotionDto promotionDto);
    Promotion update(PromotionDto promotionDto, Long promotionId);
    void delete(Long promotionId);
    List<Promotion> findByNotExpired();
    List<Promotion> findPromotionsHaveUsed();
    List<Promotion> findPromotionsByMember(Long memberId);
}
