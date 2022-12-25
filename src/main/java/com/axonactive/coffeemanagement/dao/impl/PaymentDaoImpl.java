package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.controller.request.PaymentRequest;
import com.axonactive.coffeemanagement.dao.PaymentDao;
import com.axonactive.coffeemanagement.entity.Payment;

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
    public Payment create(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        if(paymentRequest.getName()==null){
            return null;
        }
        payment.setName(paymentRequest.getName());
        payment.setImage(paymentRequest.getImage());
        return em.merge(payment);
    }

    @Override
    public Payment update(PaymentRequest paymentRequest, Long paymentId) {
        Payment payment = findById(paymentId);
        if(payment==null){
            return null;
        }
        if(paymentRequest.getName()!=null){
            payment.setName(paymentRequest.getName());
        }
        if(paymentRequest.getImage()!=null){
            payment.setImage(paymentRequest.getImage());
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
