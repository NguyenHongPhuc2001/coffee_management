package com.axonactive.coffeemanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    @NotNull(message = "The payment name can't be null !!!")
    @Size(max = 120)
    private String name;

    private String image;
}
