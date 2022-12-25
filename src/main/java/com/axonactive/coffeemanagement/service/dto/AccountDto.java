package com.axonactive.coffeemanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private String username;

    private String password;

    private RoleDto role;
}
