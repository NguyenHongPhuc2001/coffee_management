package com.axonactive.coffeemanagement.controller.request;

import com.axonactive.coffeemanagement.utils.Enum.BarTableStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarTableRequest {
    private Integer number;

    private Integer numberOfSeat;

    private String status;
}
