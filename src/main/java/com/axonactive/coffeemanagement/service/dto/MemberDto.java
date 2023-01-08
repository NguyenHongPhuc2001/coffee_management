package com.axonactive.coffeemanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    @NotNull(message = "The member phone can't be null !!!")
    @Size(max = 10)
    private String phone;

    @NotNull(message = "The member name can't be null !!!")
    @Size(max = 120)
    private String name;

    @Max(value = 500)
    private Integer bonus;
}
