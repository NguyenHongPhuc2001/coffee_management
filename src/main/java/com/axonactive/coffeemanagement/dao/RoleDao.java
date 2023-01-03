package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.entity.Role;
import com.axonactive.coffeemanagement.service.dto.RoleDto;

import java.util.List;

public interface RoleDao {
    Role create(RoleDto roleDto);
    Role update(RoleDto roleDto, Long roleId);
    void deleteById (Long roleId);
    Role findById(Long roleId);
    List<Role> findAll();
}
