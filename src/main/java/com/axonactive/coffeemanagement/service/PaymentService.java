package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.service.dto.PaymentDto;

import java.util.List;


public interface PaymentService {
    PaymentDto findById(Long paymentId);
    List<PaymentDto> findAll();
    PaymentDto create(PaymentDto paymentDto);
    PaymentDto update(PaymentDto paymentDto, Long paymentId);
    void delete(Long paymentId);

}
