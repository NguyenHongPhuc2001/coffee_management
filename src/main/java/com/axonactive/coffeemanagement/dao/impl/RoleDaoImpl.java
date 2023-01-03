package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.dao.RoleDao;
import com.axonactive.coffeemanagement.entity.Role;
import com.axonactive.coffeemanagement.service.dto.RoleDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext(name = "coffee_management")

    private EntityManager em;

    @Override
    public Role create(RoleDto roleDto) {
        if(roleDto.getName()==null){
            return null;
        }
        Role role = new Role();
        role.setName(roleDto.getName());
        role.setDescription(roleDto.getDescription());
        return em.merge(role);
    }

    @Override
    public Role update(RoleDto roleDto, Long roleId) {
        Role role = findById(roleId);
        if(role==null){
            return null;
        }
        if(roleDto.getName()!=null){
            role.setName(roleDto.getName());
        }
        if(roleDto.getDescription()!=null){
            role.setDescription(roleDto.getDescription());
        }
        return em.merge(role);
    }

    @Override
    public void deleteById(Long roleId) {
        Role role = findById(roleId);
        if(role!=null){
            em.remove(role);
        }
    }

    @Override
    public Role findById(Long roleId) {
        return em.createQuery("SELECT r FROM Role r WHERE r.id = :roleId", Role.class)
                .setParameter("roleId",roleId)
                .getSingleResult();
    }

    @Override
    public List<Role> findAll() {
        return em.createQuery("SELECT r FROM Role r")
                .getResultList();
    }
}
