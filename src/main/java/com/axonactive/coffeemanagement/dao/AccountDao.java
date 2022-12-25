package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.controller.request.AccountRequest;
import com.axonactive.coffeemanagement.entity.Account;

import java.util.List;

public interface AccountDao {
    Account findById(Long accountId);
    List<Account> findAll();
    Account create(AccountRequest accountRequest);
    Account changePassword(AccountRequest accountRequest, Long accountId);
    void delete(Long accountId);
}
