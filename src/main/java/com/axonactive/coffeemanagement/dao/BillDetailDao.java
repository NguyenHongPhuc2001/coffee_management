package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.controller.request.BillDetailRequest;
import com.axonactive.coffeemanagement.entity.BillDetail;
import com.axonactive.coffeemanagement.service.dto.BillDetailDto;

import java.util.List;

public interface BillDetailDao{
    List<BillDetail> findAll();
    BillDetail findById(Long billDetailId);
    BillDetail create(BillDetailRequest billDetailRequest);
    BillDetail update(BillDetailRequest billDetailRequest, Long billDetailId);
    void delete(Long billDetailId);
}
