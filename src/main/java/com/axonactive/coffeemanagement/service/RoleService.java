package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.controller.request.RoleRequest;
import com.axonactive.coffeemanagement.service.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto create(RoleRequest roleRequest);
    RoleDto  update(RoleRequest roleRequest, Long roleId);
    void deleteById (Long roleId);
    RoleDto  findById(Long roleId);
    List<RoleDto > findAll();
}
