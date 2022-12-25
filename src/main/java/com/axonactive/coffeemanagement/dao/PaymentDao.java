package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.controller.request.PaymentRequest;
import com.axonactive.coffeemanagement.entity.Payment;

import java.util.List;

public interface PaymentDao {
    Payment findById(Long paymentId);
    List<Payment> findAll();
    Payment create(PaymentRequest paymentRequest);
    Payment update(PaymentRequest paymentRequest, Long paymentId);
    void delete(Long paymentId);

}
