package com.axonactive.coffeemanagement.controller.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkRequest {

    private String name;

    private Double currentPrice;

    private String image;

    private String description;

    private CategoryRequest categoryRequest;
}
