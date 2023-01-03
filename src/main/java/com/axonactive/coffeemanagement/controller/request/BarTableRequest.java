package com.axonactive.coffeemanagement.controller.request;

import com.axonactive.coffeemanagement.utils.Enum.BarTableStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarTableRequest {

    @NotNull(message = "The seat's number can't be null !!!")
    @Max(50)
    private Integer number;

    @NotNull(message = "The number of seat can't be null !!!")
    @Max(4)
    private Integer numberOfSeat;

    private String status;
}
