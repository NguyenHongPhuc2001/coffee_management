package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.dao.PromotionDao;
import com.axonactive.coffeemanagement.entity.Promotion;
import com.axonactive.coffeemanagement.service.dto.PromotionDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
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
        promotion.setPromotionValue(promotionDto.getPromotionValue());
        promotion.setBonus(promotionDto.getBonus());
        promotion.setStartDate(promotionDto.getStartDate());
        promotion.setEndDate(promotionDto.getEndDate());
        promotion.setName(promotionDto.getName().trim());
        return em.merge(promotion);
    }

    @Override
    public Promotion update(PromotionDto promotionDto, Long promotionId) {
        Promotion promotion = findById(promotionId);
        if (promotion == null) {
            return null;
        }
        promotion.setPromotionValue(promotionDto.getPromotionValue());
        promotion.setBonus(promotionDto.getBonus());
        promotion.setStartDate(promotionDto.getStartDate());
        promotion.setEndDate(promotionDto.getEndDate());
        promotion.setName(promotionDto.getName().trim());
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
        Date day = new Date();
        return em.createQuery("SELECT p FROM Promotion p WHERE p.endDate >= :day", Promotion.class)
                .setParameter("day", day)
                .getResultList();
    }

    @Override
    public List<Promotion> findPromotionsHaveUsed() {
        return em.createQuery("SELECT p FROM Promotion p INNER JOIN Bill b ON p.id = b.promotion.id GROUP BY p ORDER BY p ASC", Promotion.class)
                .getResultList();
    }

    @Override
    public List<Promotion> findPromotionsByMember(Long memberId) {
        LocalDate nowDate = LocalDate.now();
        return em.createQuery("SELECT p FROM Promotion p " +
                        "INNER JOIN Member m ON m.bonus >= p.bonus " +
                        "AND m.id = :memberId AND p.endDate >= CURRENT_TIMESTAMP " +
                        "GROUP BY p " +
                        "ORDER BY p ASC", Promotion.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
