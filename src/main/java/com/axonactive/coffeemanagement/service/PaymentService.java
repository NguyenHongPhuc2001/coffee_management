package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.controller.request.PaymentRequest;
import com.axonactive.coffeemanagement.entity.Payment;
import com.axonactive.coffeemanagement.service.dto.PaymentDto;
import org.mapstruct.Mapper;

import java.util.List;


public interface PaymentService {
    PaymentDto findById(Long paymentId);
    List<PaymentDto> findAll();
    PaymentDto create(PaymentRequest paymentRequest);
    PaymentDto update(PaymentRequest paymentRequest, Long paymentId);
    void delete(Long paymentId);

}
