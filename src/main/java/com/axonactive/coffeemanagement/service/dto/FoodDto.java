package com.axonactive.coffeemanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {

    private String name;

    private Double currentPrice;

    private Double oldPrice;

    private String image;

    private String description;
}
