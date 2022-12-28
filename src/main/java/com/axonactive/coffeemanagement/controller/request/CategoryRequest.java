package com.axonactive.coffeemanagement.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    private Long id;

    private String name;

    private Integer amount;

    private String type;
}