package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.dao.PromotionDao;
import com.axonactive.coffeemanagement.entity.Promotion;
import com.axonactive.coffeemanagement.service.BillService;
import com.axonactive.coffeemanagement.service.PromotionService;
import com.axonactive.coffeemanagement.service.dto.BillDto;
import com.axonactive.coffeemanagement.service.dto.PromotionDto;
import com.axonactive.coffeemanagement.service.dto.RoleDto;
import com.axonactive.coffeemanagement.service.mapper.PromotionMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PromotionServiceImpl implements PromotionService {

    @Inject
    private PromotionDao promotionDao;

    @Inject
    private PromotionMapper promotionMapper;

    @Inject
    private BillService billService;

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

    @Override
    public List<PromotionDto> findPromotionsByMember(Long memberId) {
        return promotionMapper.toDtos(promotionDao.findPromotionsByMember(memberId));
    }

    @Override
    public List<PromotionDto> findPromotionHaveUsed() {
        List<Promotion> listPromotionHaveUsed = promotionDao.findPromotionsHaveUsed();
        List<PromotionDto> listPromotionDtoHaveUsed = new ArrayList<>();
        for (Promotion promotion : listPromotionHaveUsed) {
            listPromotionDtoHaveUsed.add(addBillsHadUsedPromotion(promotion, billService.findByPromotion(promotion.getId())));
        }
        return listPromotionDtoHaveUsed;
    }

    private PromotionDto addBillsHadUsedPromotion(Promotion promotion, List<BillDto> billDtoList) {
        PromotionDto promotionDto = promotionMapper.toDto(promotion);
        promotionDto.setBills(billDtoList);
        return promotionDto;
    }
}
