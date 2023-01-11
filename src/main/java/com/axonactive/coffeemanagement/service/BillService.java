package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.controller.request.BillRequest;
import com.axonactive.coffeemanagement.service.dto.BillDto;

import java.util.List;

public interface BillService {
    BillDto findById(Long billId);

    List<BillDto> findAll();

    BillDto create(BillRequest billRequest);

    BillDto update(BillRequest billRequest, Long billId);

    void delete(Long billId);

    List<BillDto> findByPromotion(Long promotionId);
}
