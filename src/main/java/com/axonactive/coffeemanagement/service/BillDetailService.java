package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.controller.request.BillDetailRequest;
import com.axonactive.coffeemanagement.service.dto.BillDetailDto;

import java.util.List;

public interface BillDetailService {
    List<BillDetailDto> findAll();
    BillDetailDto findById(Long billDetailId);
    BillDetailDto create(BillDetailRequest billDetailRequest);
    BillDetailDto update(BillDetailRequest billDetailRequest, Long billDetailId);
    void delete(Long billDetailId);
}
