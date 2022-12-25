package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.controller.request.AccountRequest;
import com.axonactive.coffeemanagement.dao.AccountDao;
import com.axonactive.coffeemanagement.entity.Account;
import com.axonactive.coffeemanagement.entity.Role;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class AccountDaoImpl implements AccountDao {

    @PersistenceContext(name = "coffee_management")
    EntityManager em;

    @Override
    public Account findById(Long accountId) {
        return em.createQuery("SELECT a FROM Account a WHERE a.id = :accountId", Account.class)
                .setParameter("accountId", accountId)
                .getSingleResult();
    }

    @Override
    public List<Account> findAll() {
        return em.createQuery("SELECT a FROM Account a")
                .getResultList();
    }

    @Override
    public Account create(AccountRequest accountRequest) {
        Account account = new Account();
        if(accountRequest.getUsername()==null || accountRequest.getPassword()==null || accountRequest.getRoleId()==null){
            return null;
        }
        account.setUsername(accountRequest.getUsername());
        account.setPassword(accountRequest.getPassword());
        Role role = em.createQuery("SELECT r FROM Role r WHERE r.id = :roleId", Role.class)
                .setParameter("roleId",accountRequest.getRoleId())
                .getSingleResult();
        account.setRole(role);
        return em.merge(account);
    }

    @Override
    public Account changePassword(AccountRequest accountRequest, Long accountId) {
        Account account = findById(accountId);
        if(account==null){
            return null;
        }
        if(accountRequest.getPassword()!=null){
            account.setPassword(accountRequest.getPassword());
        }
        return em.merge(account);
    }

    @Override
    public void delete(Long accountId) {
        Account account = findById(accountId);
        if(account!=null){
            em.remove(account);
        }
    }
}
