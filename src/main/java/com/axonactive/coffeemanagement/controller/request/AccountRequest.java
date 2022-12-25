package com.axonactive.coffeemanagement.controller.request;

import com.axonactive.coffeemanagement.service.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    private String username;

    private String password;

    private Long roleId;
}
