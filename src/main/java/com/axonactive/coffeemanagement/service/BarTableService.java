package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.controller.request.BarTableRequest;

import com.axonactive.coffeemanagement.service.dto.BarTableDto;

import java.util.List;

public interface BarTableService {
    BarTableDto findById(Long barTableId);
    List<BarTableDto> findAll();
    BarTableDto create(BarTableRequest barTableRequest);
    BarTableDto update(BarTableRequest barTableRequest, Long barTableId);
    void delete(Long barTableId);
    List<BarTableDto> findByStatus(String barTableStatus);
}
