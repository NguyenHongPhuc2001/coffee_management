package com.axonactive.coffeemanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    @NotNull(message = "The member phone can't be null !!!")
    private String phone;

    @NotNull(message = "The member name can't be null !!!")
    private String name;

    private Integer bonus;
}
