package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.controller.request.PaymentRequest;
import com.axonactive.coffeemanagement.dao.PaymentDao;
import com.axonactive.coffeemanagement.service.PaymentService;
import com.axonactive.coffeemanagement.service.dto.PaymentDto;
import com.axonactive.coffeemanagement.service.mapper.PaymentMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PaymentServiceImpl implements PaymentService {
    @Inject
    private PaymentDao paymentDao;

    @Inject
    private PaymentMapper paymentMapper;

    @Override
    public PaymentDto findById(Long paymentId) {
        return paymentMapper.toDto(paymentDao.findById(paymentId));
    }

    @Override
    public List<PaymentDto> findAll() {
        return paymentMapper.toDtos(paymentDao.findAll());
    }

    @Override
    public PaymentDto create(PaymentRequest paymentRequest) {
        return paymentMapper.toDto(paymentDao.create(paymentRequest));
    }

    @Override
    public PaymentDto update(PaymentRequest paymentRequest, Long paymentId) {
        return paymentMapper.toDto(paymentDao.update(paymentRequest,paymentId));
    }

    @Override
    public void delete(Long paymentId) {
        paymentDao.delete(paymentId);
    }
}
