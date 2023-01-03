package com.axonactive.coffeemanagement.dao.impl;

import com.axonactive.coffeemanagement.controller.request.AccountRequest;
import com.axonactive.coffeemanagement.dao.AccountDao;
import com.axonactive.coffeemanagement.dao.RoleDao;
import com.axonactive.coffeemanagement.entity.Account;
import com.axonactive.coffeemanagement.entity.Role;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class AccountDaoImpl implements AccountDao {

    @PersistenceContext(name = "coffee_management")

    EntityManager em;

    @Inject
    private RoleDao roleDao;

    @Override
    public Account findById(Long accountId) {
        return em.createQuery("SELECT a FROM Account a WHERE a.id = :accountId", Account.class)
                .setParameter("accountId", accountId)
                .getSingleResult();
    }

    @Override
    public List<Account> findAll() {
        return em.createQuery("SELECT a FROM Account a", Account.class)
                .getResultList();
    }

    @Override
    public Account create(AccountRequest accountRequest) {
        Account account = new Account();
        account.setUsername(accountRequest.getUsername().trim());
        account.setPassword(accountRequest.getPassword().trim());
        Role role = roleDao.findById(accountRequest.getRoleId());
        account.setRole(role);
        return em.merge(account);
    }

    @Override
    public Account changePassword(AccountRequest accountRequest, Long accountId) {
        Account account = findById(accountId);
        account.setPassword(accountRequest.getPassword().trim());
        return em.merge(account);
    }

    @Override
    public void delete(Long accountId) {
        Account account = findById(accountId);
        if (account != null) {
            em.remove(account);
        }
    }
}
