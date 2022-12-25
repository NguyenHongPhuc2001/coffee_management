package com.axonactive.coffeemanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionDto {
    private Integer bonus;

    private String name;

    private Double promotionValue;

    private Date startDate;

    private Date endDate;

    private Date updatedDate;
}
