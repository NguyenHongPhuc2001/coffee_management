package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.dao.PaymentDao;
import com.axonactive.coffeemanagement.entity.Payment;
import com.axonactive.coffeemanagement.service.dto.PaymentDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PaymentDaoImpl implements PaymentDao {

    @PersistenceContext(name = "coffee_management")

    EntityManager em;

    @Override
    public Payment findById(Long paymentId) {
        return em.createQuery("SELECT p FROM Payment p WHERE p.id = :paymentId", Payment.class)
                .setParameter("paymentId",paymentId)
                .getSingleResult();
    }

    @Override
    public List<Payment> findAll() {
        return em.createQuery("SELECT p FROM Payment p")
                .getResultList();
    }

    @Override
    public Payment create(PaymentDto paymentDto) {
        Payment payment = new Payment();
        if(paymentDto.getName()==null){
            return null;
        }
        payment.setName(paymentDto.getName());
        payment.setImage(paymentDto.getImage());
        return em.merge(payment);
    }

    @Override
    public Payment update(PaymentDto paymentDto, Long paymentId) {
        Payment payment = findById(paymentId);
        if(payment==null){
            return null;
        }
        if(paymentDto.getName()!=null){
            payment.setName(paymentDto.getName());
        }
        if(paymentDto.getImage()!=null){
            payment.setImage(paymentDto.getImage());
        }
        return em.merge(payment);
    }

    @Override
    public void delete(Long paymentId) {
        Payment payment = findById(paymentId);
        if(payment!=null){
            em.remove(payment);
        }
    }
}
