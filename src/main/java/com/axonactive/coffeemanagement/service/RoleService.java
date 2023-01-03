package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.service.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto create(RoleDto roleDto);
    RoleDto  update(RoleDto roleDto, Long roleId);
    void deleteById (Long roleId);
    RoleDto  findById(Long roleId);
    List<RoleDto > findAll();
}
