package com.axonactive.coffeemanagement.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequest {

    @NotNull(message = "The food name can't be null !!!")
    @Size(max = 150)
    private String name;

    @NotNull(message = "The current price can't be null !!!")
    private Double currentPrice;

    private String image;

    private String description;

    @NotNull(message = "The category can't be null")
    private CategoryRequest categoryRequest;
}
