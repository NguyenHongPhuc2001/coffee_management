package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.controller.request.PromotionRequest;
import com.axonactive.coffeemanagement.service.dto.PromotionDto;

import java.util.Date;
import java.util.List;

public interface PromotionService {
    PromotionDto findById(Long promotionId);
    List<PromotionDto> findAll();
    PromotionDto create(PromotionRequest promotionRequest);
    PromotionDto update(PromotionRequest promotionRequest, Long promotionId);
    void delete(Long promotionId);
    List<PromotionDto> findByNotExpired();
}
