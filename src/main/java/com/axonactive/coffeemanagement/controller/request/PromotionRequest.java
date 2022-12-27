package com.axonactive.coffeemanagement.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionRequest {
    private Integer bonus;

    private String name;

    private Double promotionValue;

    private Date startDate;

    private Date endDate;
}
