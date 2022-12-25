package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.controller.request.RoleRequest;
import com.axonactive.coffeemanagement.dao.RoleDao;
import com.axonactive.coffeemanagement.entity.Role;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext(name = "coffee_management")

    private EntityManager em;

    @Override
    public Role create(RoleRequest roleRequest) {
        if(roleRequest.getName()==null){
            return null;
        }
        Role role = new Role();
        role.setName(roleRequest.getName());
        role.setDescription(roleRequest.getDescription());
        return em.merge(role);
    }

    @Override
    public Role update(RoleRequest roleRequest, Long roleId) {
        Role role = findById(roleId);
        if(role==null){
            return null;
        }
        if(roleRequest.getName()!=null){
            role.setName(roleRequest.getName());
        }
        if(roleRequest.getDescription()!=null){
            role.setDescription(roleRequest.getDescription());
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
