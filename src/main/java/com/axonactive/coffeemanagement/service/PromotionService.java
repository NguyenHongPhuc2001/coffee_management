package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.service.dto.PromotionDto;

import java.util.List;

public interface PromotionService {
    PromotionDto findById(Long promotionId);
    List<PromotionDto> findAll();
    PromotionDto create(PromotionDto promotionDto);
    PromotionDto update(PromotionDto promotionDto, Long promotionId);
    void delete(Long promotionId);
    List<PromotionDto> findByNotExpired();
}
