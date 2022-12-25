package com.axonactive.coffeemanagement.service;

import com.axonactive.coffeemanagement.controller.request.AccountRequest;
import com.axonactive.coffeemanagement.entity.Account;
import com.axonactive.coffeemanagement.service.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto findById(Long accountId);
    List<AccountDto> findAll();
    AccountDto create(AccountRequest accountRequest);
    AccountDto changePassword(AccountRequest accountRequest, Long accountId);
    void delete(Long accountId);
}
