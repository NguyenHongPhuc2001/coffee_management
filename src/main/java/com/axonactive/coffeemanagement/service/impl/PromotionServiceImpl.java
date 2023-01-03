package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.dao.PromotionDao;
import com.axonactive.coffeemanagement.service.PromotionService;
import com.axonactive.coffeemanagement.service.dto.PromotionDto;
import com.axonactive.coffeemanagement.service.dto.RoleDto;
import com.axonactive.coffeemanagement.service.mapper.PromotionMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
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
    public PromotionDto create(PromotionDto promotionDto) {
        return promotionMapper.toDto(promotionDao.create(promotionDto));
    }

    @Override
    public PromotionDto update(PromotionDto promotionDto, Long promotionId) {
        return promotionMapper.toDto(promotionDao.update(promotionDto, promotionId));
    }

    @Override
    public void delete(Long promotionId) {
        promotionDao.delete(promotionId);
    }

    @Override
    public List<PromotionDto> findByNotExpired() {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return promotionMapper.toDtos(promotionDao.findByNotExpired());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
