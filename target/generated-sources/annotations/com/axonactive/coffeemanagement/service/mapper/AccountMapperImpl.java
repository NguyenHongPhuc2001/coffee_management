package com.axonactive.coffeemanagement.service.mapper;

import com.axonactive.coffeemanagement.entity.Account;
import com.axonactive.coffeemanagement.entity.Role;
import com.axonactive.coffeemanagement.service.dto.AccountDto;
import com.axonactive.coffeemanagement.service.dto.RoleDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-08T18:49:51+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@ApplicationScoped
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto toDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setUsername( account.getUsername() );
        accountDto.setPassword( account.getPassword() );
        accountDto.setRole( roleToRoleDto( account.getRole() ) );

        return accountDto;
    }

    @Override
    public List<AccountDto> toDtos(List<Account> accountList) {
        if ( accountList == null ) {
            return null;
        }

        List<AccountDto> list = new ArrayList<AccountDto>( accountList.size() );
        for ( Account account : accountList ) {
            list.add( toDto( account ) );
        }

        return list;
    }

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setName( role.getName() );
        roleDto.setDescription( role.getDescription() );

        return roleDto;
    }
}
