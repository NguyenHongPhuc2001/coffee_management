package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.controller.request.BillRequest;
import com.axonactive.coffeemanagement.dao.BillDao;
import com.axonactive.coffeemanagement.service.BillService;
import com.axonactive.coffeemanagement.service.dto.BillDto;
import com.axonactive.coffeemanagement.service.mapper.BillMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BillServiceImpl implements BillService {

    @Inject
    private BillDao billDao;

    @Inject
    private BillMapper billMapper;

    @Override
    public BillDto findById(Long billId) {
        return billMapper.toDto(billDao.findById(billId));
    }

    @Override
    public List<BillDto> findAll() {
        return billMapper.toDtos(billDao.findAll());
    }

    @Override
    public BillDto create(BillRequest billRequest) {
        return billMapper.toDto(billDao.create(billRequest));
    }

    @Override
    public BillDto update(BillRequest billRequest, Long billId) {
        return billMapper.toDto(billDao.update(billRequest, billId));
    }

    @Override
    public void delete(Long billId) {
        billDao.delete(billId);
    }
}
