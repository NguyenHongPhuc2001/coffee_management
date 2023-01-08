package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.controller.request.BillDetailRequest;
import com.axonactive.coffeemanagement.dao.BillDetailDao;
import com.axonactive.coffeemanagement.service.BillDetailService;
import com.axonactive.coffeemanagement.service.dto.BillDetailDto;
import com.axonactive.coffeemanagement.service.mapper.BillDetailMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BillDetailServiceImpl implements BillDetailService {

    @Inject
    private BillDetailDao billDetailDao;

    @Inject
    private BillDetailMapper billDetailMapper;

    @Override
    public List<BillDetailDto> findAll() {
        return billDetailMapper.toDtos(billDetailDao.findAll());
    }

    @Override
    public BillDetailDto findById(Long billDetailId) {
        return billDetailMapper.toDto(billDetailDao.findById(billDetailId));
    }

    @Override
    public BillDetailDto create(BillDetailRequest billDetailRequest) {
        return billDetailMapper.toDto(billDetailDao.create(billDetailRequest));
    }

    @Override
    public BillDetailDto update(BillDetailRequest billDetailRequest, Long billDetailId) {
        return billDetailMapper.toDto(billDetailDao.update(billDetailRequest, billDetailId));
    }

    @Override
    public void delete(Long billDetailId) {
        billDetailDao.delete(billDetailId);
    }
}
