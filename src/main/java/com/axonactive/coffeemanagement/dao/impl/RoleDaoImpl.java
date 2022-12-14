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
        Role role = new Role();
        role.setName(roleDto.getName().trim());
        role.setDescription(roleDto.getDescription().trim());
        return em.merge(role);
    }

    @Override
    public Role findById(Long roleId) {
        return em.createQuery("SELECT r FROM Role r WHERE r.id = :roleId", Role.class)
                .setParameter("roleId", roleId)
                .getSingleResult();
    }
    @Override
    public Role update(RoleDto roleDto, Long roleId) {
        Role role = findById(roleId);
        role.setName(roleDto.getName().trim());
        role.setDescription(roleDto.getDescription().trim());
        return em.merge(role);
    }

    @Override
    public void deleteById(Long roleId) {
        Role role = findById(roleId);
        if (role != null) {
            em.remove(role);
        }
    }

    @Override
    public List<Role> findAll() {
        return em.createQuery("SELECT r FROM Role r", Role.class)
                .getResultList();
    }
}
