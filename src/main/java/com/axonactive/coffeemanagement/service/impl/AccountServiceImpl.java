package com.axonactive.coffeemanagement.service.impl;

import com.axonactive.coffeemanagement.controller.request.AccountRequest;
import com.axonactive.coffeemanagement.dao.AccountDao;
import com.axonactive.coffeemanagement.service.AccountService;
import com.axonactive.coffeemanagement.service.dto.AccountDto;
import com.axonactive.coffeemanagement.service.mapper.AccountMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;


@Stateless
public class AccountServiceImpl implements AccountService {

    @Inject
    private AccountDao accountDao;

    @Inject
    private AccountMapper accountMapper;

    @Override
    public AccountDto findById(Long accountId) {
        return accountMapper.toDto(accountDao.findById(accountId));
    }

    @Override
    public List<AccountDto> findAll() {
        return accountMapper.toDtos(accountDao.findAll());
    }

    @Override
    public AccountDto create(AccountRequest accountRequest) {
        return accountMapper.toDto(accountDao.create(accountRequest));
    }

    @Override
    public AccountDto changePassword(AccountRequest accountRequest, Long accountId) {
        return accountMapper.toDto(accountDao.changePassword(accountRequest,accountId));
    }

    @Override
    public void delete(Long accountId) {
        accountDao.delete(accountId);
    }
}
