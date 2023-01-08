package com.axonactive.coffeemanagement.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDetailRequest {

    @NotNull(message = "The quantity can't be null !!!")
    private Integer quantity;

    @NotNull(message = "The bill Id can't be null !!!")
    private Long billId;

    private Long foodId;

    private Long drinkId;
}
