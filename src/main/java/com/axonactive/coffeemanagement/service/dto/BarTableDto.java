package com.axonactive.coffeemanagement.service.dto;

import com.axonactive.coffeemanagement.utils.Enum.BarTableStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarTableDto {
    private Integer number;

    private Integer numberOfSeat;

    private BarTableStatusEnum status;
}
