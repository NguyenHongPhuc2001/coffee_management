package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.controller.request.BillDetailRequest;
import com.axonactive.coffeemanagement.dao.BillDao;
import com.axonactive.coffeemanagement.dao.BillDetailDao;
import com.axonactive.coffeemanagement.dao.DrinkDao;
import com.axonactive.coffeemanagement.dao.FoodDao;
import com.axonactive.coffeemanagement.entity.BillDetail;
import com.axonactive.coffeemanagement.service.dto.BillDetailDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BillDetailDaoImpl implements BillDetailDao {

    @PersistenceContext(name = "coffee_management")

    EntityManager em;


    @Inject
    private FoodDao foodDao;

    @Inject
    private DrinkDao drinkDao;

    @Inject
    private BillDao billDao;

    @Override
    public List<BillDetail> findAll() {
        return em.createQuery("SELECT bd FROM BillDetail bd", BillDetail.class).getResultList();
    }

    @Override
    public BillDetail findById(Long billDetailId) {
        return em.createQuery("SELECT bd FROM BillDetail bd WHERE bd.if = :billDetailId", BillDetail.class)
                .setParameter("billDetailId", billDetailId)
                .getSingleResult();
    }

    @Override
    public BillDetail create(BillDetailRequest billDetailRequest) {
        BillDetail billDetail = new BillDetail();
        billDetail.setQuantity(billDetailRequest.getQuantity());
        if (billDetailRequest.getDrinkId() != null) {
            billDetail.setDrink(drinkDao.findById(billDetailRequest.getDrinkId()));
            billDetail.setTotal(billDetailRequest.getQuantity() * drinkDao.findById(billDetailRequest
                    .getDrinkId()).getPrice());
        }
        if (billDetailRequest.getFoodId() != null) {
            billDetail.setFood(foodDao.findById(billDetailRequest.getFoodId()));
            billDetail.setTotal(billDetailRequest.getQuantity() * foodDao.findById(billDetailRequest
                    .getFoodId()).getPrice());

        }
        billDetail.setBill(billDao.findById(billDetailRequest.getBillId()));
        return em.merge(billDetail);
    }

    @Override
    public BillDetail update(BillDetailRequest billDetailRequest, Long billDetailId) {
        BillDetail billDetail = findById(billDetailId);
        if (billDetail == null) {
            return null;
        }
        billDetail.setQuantity(billDetailRequest.getQuantity());
        if (billDetailRequest.getDrinkId() != null) {
            billDetail.setDrink(drinkDao.findById(billDetailRequest.getDrinkId()));
            billDetail.setTotal(billDetailRequest.getQuantity() * drinkDao.findById(billDetailRequest
                    .getDrinkId()).getPrice());
        }
        if (billDetailRequest.getFoodId() != null) {
            billDetail.setFood(foodDao.findById(billDetailRequest.getFoodId()));
            billDetail.setTotal(billDetailRequest.getQuantity() * foodDao.findById(billDetailRequest
                    .getFoodId()).getPrice());

        }
        billDetail.setBill(billDao.findById(billDetailRequest.getBillId()));
        return em.merge(billDetail);
    }

    @Override
    public void delete(Long billDetailId) {
        BillDetail billDetail = findById(billDetailId);
        if (billDetail != null) {
            em.remove(billDetail);
        }
    }
}
