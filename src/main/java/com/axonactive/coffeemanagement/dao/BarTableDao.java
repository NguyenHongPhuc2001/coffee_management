package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.controller.request.BarTableRequest;
import com.axonactive.coffeemanagement.entity.BarTable;

import java.util.List;

public interface BarTableDao {
    BarTable findById(Long barTableId);
    List<BarTable> findAll();
    BarTable create(BarTableRequest barTableRequest);
    BarTable update(BarTableRequest barTableRequest, Long barTableId);
    void delete(Long barTableId);
    List<BarTable> findByStatus(String barTableStatus);
}
