package com.axonactive.coffeemanagement.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {

    private Long id;

    @NotNull(message = "The category name can't be null !!!")
    private String name;

    private Integer amount;

    private String type;
}
