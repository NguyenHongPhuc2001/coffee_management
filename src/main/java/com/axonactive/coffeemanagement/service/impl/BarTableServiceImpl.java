package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.controller.request.BarTableRequest;
import com.axonactive.coffeemanagement.dao.BarTableDao;
import com.axonactive.coffeemanagement.service.BarTableService;
import com.axonactive.coffeemanagement.service.dto.BarTableDto;
import com.axonactive.coffeemanagement.service.mapper.BarTableMapper;
import com.axonactive.coffeemanagement.utils.Enum.BarTableStatusEnum;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BarTableServiceImpl implements BarTableService {

    @Inject
    private BarTableDao barTableDao;

    @Inject
    private BarTableMapper barTableMapper;

    @Override
    public BarTableDto findById(Long barTableId) {
        return barTableMapper.toDto(barTableDao.findById(barTableId));
    }

    @Override
    public List<BarTableDto> findAll() {
        return barTableMapper.toDtos(barTableDao.findAll());
    }

    @Override
    public BarTableDto create(BarTableRequest barTableRequest) {
        return barTableMapper.toDto(barTableDao.create(barTableRequest));
    }

    @Override
    public BarTableDto update(BarTableRequest barTableRequest, Long barTableId) {
        return barTableMapper.toDto(barTableDao.update(barTableRequest, barTableId));
    }

    @Override
    public void delete(Long barTableId) {
        barTableDao.delete(barTableId);
    }

    @Override
    public List<BarTableDto> findByStatus(String barTableStatus) {
        return barTableMapper.toDtos(barTableDao.findByStatus(BarTableStatusEnum.valueOf(barTableStatus)));
    }
}
