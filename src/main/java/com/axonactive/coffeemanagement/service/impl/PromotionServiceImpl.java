package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.controller.request.PromotionRequest;
import com.axonactive.coffeemanagement.dao.PromotionDao;
import com.axonactive.coffeemanagement.service.PromotionService;
import com.axonactive.coffeemanagement.service.dto.PromotionDto;
import com.axonactive.coffeemanagement.service.mapper.PromotionMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Stateless
public class PromotionServiceImpl implements PromotionService {

    @Inject
    private PromotionDao promotionDao;

    @Inject
    private PromotionMapper promotionMapper;

    @Override
    public PromotionDto findById(Long promotionId) {
        return promotionMapper.toDto(promotionDao.findById(promotionId));
    }

    @Override
    public List<PromotionDto> findAll() {
        return promotionMapper.toDtos(promotionDao.findAll());
    }

    @Override
    public PromotionDto create(PromotionRequest promotionRequest) {
        return promotionMapper.toDto(promotionDao.create(promotionRequest));
    }

    @Override
    public PromotionDto update(PromotionRequest promotionRequest, Long promotionId) {
        return promotionMapper.toDto(promotionDao.update(promotionRequest, promotionId));
    }

    @Override
    public void delete(Long promotionId) {
        promotionDao.delete(promotionId);
    }

    @Override
    public List<PromotionDto> findByNotExpired(String toDay) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = df.parse(toDay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return promotionMapper.toDtos(promotionDao.findByNotExpired(date));
    }
}
