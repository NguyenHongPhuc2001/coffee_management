package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.entity.Payment;
import com.axonactive.coffeemanagement.service.dto.PaymentDto;

import java.util.List;

public interface PaymentDao {
    Payment findById(Long paymentId);
    List<Payment> findAll();
    Payment create(PaymentDto paymentDto);
    Payment update(PaymentDto paymentDto, Long paymentId);
    void delete(Long paymentId);

}
