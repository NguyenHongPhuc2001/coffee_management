package com.axonactive.coffeemanagement.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillRequest {



    @NotNull(message = "The actualReceived can't be null !!!")
    private Double actualReceived;

    private Double total;

    private String status;

    private Long barTableId;

    private Long memberId;

    private Long paymentId;

    private Long promotionId;

    private Long accountId;
}
