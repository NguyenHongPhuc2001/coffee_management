package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.controller.request.BillRequest;
import com.axonactive.coffeemanagement.dao.*;
import com.axonactive.coffeemanagement.entity.Bill;
import com.axonactive.coffeemanagement.entity.Drink;
import com.axonactive.coffeemanagement.entity.Food;
import com.axonactive.coffeemanagement.utils.Enum.BillStatusEnum;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.util.List;

@Stateless
public class BillDaoImpl implements BillDao {

    @PersistenceContext(name = "coffee_management")

    EntityManager em;

    @Inject
    private AccountDao accountDao;

    @Inject
    private BarTableDao barTableDao;


    @Inject
    private PaymentDao paymentDao;

    @Inject
    private MemberDao memberDao;

    @Inject
    private PromotionDao promotionDao;

    @Override
    public Bill findById(Long billId) {
        return em.createQuery("SELECT b FROM Bill b WHERE b.id = :billId", Bill.class)
                .setParameter("billId", billId)
                .getSingleResult();
    }

    @Override
    public List<Bill> findAll() {
        return em.createQuery("SELECT b FROM Bill b", Bill.class)
                .getResultList();
    }

    @Override
    public Bill create(BillRequest billRequest) {
        Bill bill = new Bill();
        bill.setAccount(accountDao.findById(billRequest.getAccountId()));
        bill.setBarTable(barTableDao.findById(billRequest.getBarTableId()));
        bill.setPayment(paymentDao.findById(billRequest.getPaymentId()));
        if (billRequest.getMemberId() != null) {
            bill.setMember(memberDao.findById(billRequest.getMemberId()));
        }
        if (billRequest.getPromotionId() != null) {
            bill.setPromotion(promotionDao.findById(billRequest.getPromotionId()));
        }
        bill.setActualReceived(billRequest.getActualReceived());
        bill.setStatus(BillStatusEnum.UNCHECKED);
        bill.setTotal(0.0);
        return em.merge(bill);
    }

    @Override
    public Bill update(BillRequest billRequest, Long billId) {
        Bill bill = findById(billId);
        if (bill == null) {
            return null;
        }
        if (billRequest.getPaymentId() != null) {
            bill.setPayment(paymentDao.findById(billRequest.getPaymentId()));
        }
        if (billRequest.getBarTableId() != null) {
            bill.setBarTable(barTableDao.findById(billRequest.getBarTableId()));
        }
        if (billRequest.getMemberId() != null) {
            bill.setMember(memberDao.findById(billRequest.getMemberId()));
        }
        if (billRequest.getPromotionId() != null) {
            bill.setPromotion(promotionDao.findById(billRequest.getPromotionId()));
        }
        if (billRequest.getStatus() != null) {
            bill.setStatus(BillStatusEnum.valueOf(billRequest.getStatus().toUpperCase()));
        }
        if (billRequest.getTotal() != null || billRequest.getTotal() != 0) {
            bill.setTotal(billRequest.getTotal());
        }
        bill.setActualReceived(billRequest.getActualReceived());
        return em.merge(bill);
    }

    @Override
    public void delete(Long billId) {
        Bill bill = findById(billId);
        if (bill != null) {
            em.remove(bill);
        }
    }

    @Override
    public List<Bill> findByCreatedDate(String createdDate) {
        return em.createQuery("SELECT b FROM Bill b WHERE b.createdDate = :createdDate", Bill.class)
                .setParameter("createdDate", createdDate)
                .getResultList();
    }

    @Override
    public List<Bill> findByMember(Long memberId) {
        return em.createQuery("SELECT b FROM Bill b WHERE b.member.id = :memberId", Bill.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    @Override
    public List<Bill> findByPayment(Long paymentId) {
        return em.createQuery("SELECT b FROM Bill b WHERE b.payment.id = :paymentId", Bill.class)
                .setParameter("paymentId", paymentId)
                .getResultList();
    }

    @Override
    public List<Bill> findByBarTableAndCreatedDate(Long barTableId, String createdDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return em.createQuery("SELECT b FROM Bill b WHERE b.barTable.id = :barTableId AND b.createdDate = :createdDate", Bill.class)
                .setParameter("barTableId", barTableId)
                .setParameter("createdDate", createdDate)
                .getResultList();
    }

    @Override
    public List<Bill> findByStatus(String status) {
        return em.createQuery("SELECT b FROM Bill b WHERE b.status = :status", Bill.class)
                .setParameter("status", BillStatusEnum.valueOf(status))
                .getResultList();
    }

    @Override
    public List<Bill> findByTotalAndCreatedDate(Double total, String createdDate) {
        return em.createQuery("SELECT b FROM Bill b WHERE b.total = :total AND b.createdDate = :createdDate", Bill.class)
                .setParameter("createdDate", createdDate)
                .setParameter("total", total)
                .getResultList();
    }

    @Override
    public List<Bill> findByMemberAndCreatedDate(Long memberId, String createdDate) {
        return em.createQuery("SELECT b FROM Bill b WHERE b.member.id  = :memberId AND b.createdDate = :createdDate", Bill.class)
                .setParameter("createdDate", createdDate)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    @Override
    public List<Bill> findByTotalAndPromotionAndCreatedDate(Double total, Long promotionId, String createdDate) {
        return null;
    }

    @Override
    public List<Bill> findByPromotion(Long promotionId) {
        return em.createQuery("SELECT b FROM Bill b INNER JOIN Promotion p " +
                        "ON b.promotion.id = :promotionId " +
                        "GROUP BY b " +
                        "ORDER BY b ASC", Bill.class)
                .setParameter("promotionId", promotionId)
                .getResultList();
    }

    @Override
    public Double findTotalByCreatedDateAndStatus(String createdDate, String status) {
        return null;
    }

    @Override
    public Double findTotalByFoodAndDate(Long foodId, String date) {
        return null;
    }

    @Override
    public Double findTotalByDrinkAndDate(Long drinkId, String date) {
        return null;
    }

    @Override
    public List<Food> findFoodsWasBoughtInMonth(String date) {
        return null;
    }

    @Override
    public List<Drink> findDrinksWasBoughtInMonth(String date) {
        return null;
    }
}
