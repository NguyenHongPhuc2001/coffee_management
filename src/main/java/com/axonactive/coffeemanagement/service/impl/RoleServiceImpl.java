package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.controller.request.RoleRequest;
import com.axonactive.coffeemanagement.dao.RoleDao;
import com.axonactive.coffeemanagement.entity.Role;
import com.axonactive.coffeemanagement.service.RoleService;
import com.axonactive.coffeemanagement.service.dto.RoleDto;
import com.axonactive.coffeemanagement.service.mapper.RoleMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;



@Stateless
public class RoleServiceImpl implements RoleService {

    @Inject
    private RoleDao roleDao;

    @Inject
    private RoleMapper roleMapper;


    @Override
    public RoleDto create(RoleRequest roleRequest) {
        return roleMapper.toDto(roleDao.create(roleRequest));
    }

    @Override
    public RoleDto update(RoleRequest roleRequest, Long roleId) {
        return roleMapper.toDto(roleDao.update(roleRequest,roleId));
    }

    @Override
    public void deleteById(Long roleId) {
        roleDao.deleteById(roleId);
    }

    @Override
    public RoleDto findById(Long roleId) {
        return roleMapper.toDto(roleDao.findById(roleId));
    }

    @Override
    public List<RoleDto> findAll() {
        return roleMapper.toDtos(roleDao.findAll());
    }
}
