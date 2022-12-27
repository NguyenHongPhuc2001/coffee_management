package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.controller.request.PromotionRequest;
import com.axonactive.coffeemanagement.dao.PromotionDao;
import com.axonactive.coffeemanagement.entity.Promotion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
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
    public Promotion create(PromotionRequest promotionRequest) {
        Promotion promotion = new Promotion();
        if (promotionRequest.getPromotionValue() == null || promotionRequest.getBonus() == null
                || promotionRequest.getPromotionValue() == 0 || promotionRequest.getName() == null ||
                promotionRequest.getStartDate() == null || promotionRequest.getEndDate() == null) {
            return null;
        }
        promotion.setPromotionValue(promotionRequest.getPromotionValue());
        promotion.setBonus(promotionRequest.getBonus());
        promotion.setStartDate(promotionRequest.getStartDate());
        promotion.setEndDate(promotionRequest.getEndDate());
        promotion.setName(promotionRequest.getName());
        return em.merge(promotion);
    }

    @Override
    public Promotion update(PromotionRequest promotionRequest, Long promotionId) {
        Promotion promotion = findById(promotionId);
        if (promotion == null) {
            return null;
        }
        if (promotionRequest.getPromotionValue() != null) {
            promotion.setPromotionValue(promotionRequest.getPromotionValue());
        }
        if (promotionRequest.getBonus() != null) {
            promotion.setBonus(promotionRequest.getBonus());
        }
        if (promotionRequest.getStartDate() != null) {
            promotion.setStartDate(promotionRequest.getStartDate());
        }
        if (promotionRequest.getEndDate() != null) {
            promotion.setEndDate(promotionRequest.getEndDate());
        }
        if (promotionRequest.getName() != null) {
            promotion.setName(promotionRequest.getName());
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
