package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Account;
import com.axonactive.coffeemanagement.service.dto.AccountDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface AccountMapper {
    AccountDto toDto(Account account);

    List<AccountDto> toDtos(List<Account> accountList);
}
