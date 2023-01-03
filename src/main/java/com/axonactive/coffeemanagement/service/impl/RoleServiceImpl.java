package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.dao.RoleDao;
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
    public RoleDto create(RoleDto roleDto) {
        return roleMapper.toDto(roleDao.create(roleDto));
    }

    @Override
    public RoleDto update(RoleDto roleDto, Long roleId) {
        return roleMapper.toDto(roleDao.update(roleDto,roleId));
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
