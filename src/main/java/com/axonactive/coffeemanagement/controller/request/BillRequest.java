package com.axonactive.coffeemanagement.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillRequest {

    private Double total;

    private String status;

    private Long barTableId;

    private Long memberId;

    private Long paymentId;

    private Long promotionId;

    private Long accountId;
}
