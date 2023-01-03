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
                .setParameter("paymentId", paymentId)
                .getSingleResult();
    }

    @Override
    public List<Payment> findAll() {
        return em.createQuery("SELECT p FROM Payment p", Payment.class)
                .getResultList();
    }

    @Override
    public Payment create(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setName(paymentDto.getName().trim());
        payment.setImage(paymentDto.getImage().trim());
        return em.merge(payment);
    }

    @Override
    public Payment update(PaymentDto paymentDto, Long paymentId) {
        Payment payment = findById(paymentId);
        payment.setName(paymentDto.getName().trim());
        payment.setImage(paymentDto.getImage().trim());
        return em.merge(payment);
    }

    @Override
    public void delete(Long paymentId) {
        Payment payment = findById(paymentId);
        if (payment != null) {
            em.remove(payment);
        }
    }
}
