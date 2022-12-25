package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.controller.request.RoleRequest;
import com.axonactive.coffeemanagement.entity.Role;

import java.util.List;

public interface RoleDao {
    Role create(RoleRequest roleRequest);
    Role update(RoleRequest roleRequest, Long roleId);
    void deleteById (Long roleId);
    Role findById(Long roleId);
    List<Role> findAll();
}
