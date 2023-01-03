package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.dao.PromotionDao;
import com.axonactive.coffeemanagement.entity.Promotion;
import com.axonactive.coffeemanagement.service.dto.PromotionDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;


@Stateless
public class PromotionDaoImpl implements PromotionDao {

    @PersistenceContext(name = "coffee_management")

    EntityManager em;

    @Override
    public Promotion findById(Long promotionId) {
        return em.createQuery("SELECT p FROM Promotion p WHERE p.id = :promotionId", Promotion.class)
                .setParameter("promotionId", promotionId)
                .getSingleResult();
    }

    @Override
    public List<Promotion> findAll() {
        return em.createQuery("SELECT p FROM Promotion p", Promotion.class)
                .getResultList();
    }

    @Override
    public Promotion create(PromotionDto promotionDto) {
        Promotion promotion = new Promotion();
        if (promotionDto.getPromotionValue() == null || promotionDto.getBonus() == null
                || promotionDto.getPromotionValue() == 0 || promotionDto.getName() == null ||
                promotionDto.getStartDate() == null || promotionDto.getEndDate() == null) {
            return null;
        }
        promotion.setPromotionValue(promotionDto.getPromotionValue());
        promotion.setBonus(promotionDto.getBonus());
        promotion.setStartDate(promotionDto.getStartDate());
        promotion.setEndDate(promotionDto.getEndDate());
        promotion.setName(promotionDto.getName());
        return em.merge(promotion);
    }

    @Override
    public Promotion update(PromotionDto promotionDto, Long promotionId) {
        Promotion promotion = findById(promotionId);
        if (promotion == null) {
            return null;
        }
        if (promotionDto.getPromotionValue() != null) {
            promotion.setPromotionValue(promotionDto.getPromotionValue());
        }
        if (promotionDto.getBonus() != null) {
            promotion.setBonus(promotionDto.getBonus());
        }
        if (promotionDto.getStartDate() != null) {
            promotion.setStartDate(promotionDto.getStartDate());
        }
        if (promotionDto.getEndDate() != null) {
            promotion.setEndDate(promotionDto.getEndDate());
        }
        if (promotionDto.getName() != null) {
            promotion.setName(promotionDto.getName());
        }
        return em.merge(promotion);
    }

    @Override
    public void delete(Long promotionId) {
        Promotion promotion = findById(promotionId);
        if (promotion != null) {
            em.remove(promotion);
        }
    }

    @Override
    public List<Promotion> findByNotExpired() {
        Date day =new Date();
        return em.createQuery("SELECT p FROM Promotion p WHERE p.endDate >= :day", Promotion.class)
                .setParameter("day", day)
                .getResultList();
    }
}
