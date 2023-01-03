package com.axonactive.coffeemanagement.controller.request;

import com.axonactive.coffeemanagement.service.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {

    @NotNull(message = "The username can't be null !!!")
    @Size(max = 30)
    private String username;

    @NotNull(message = "The password can't be null !!!")
    @Size(max = 50)
    private String password;

    @NotNull(message = "The roleId can't be null !!!")
    private Long roleId;
}
