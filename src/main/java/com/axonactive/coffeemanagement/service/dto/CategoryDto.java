package com.axonactive.coffeemanagement.service.dto;

import com.axonactive.coffeemanagement.utils.Enum.CategoryTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private String name;

    private Integer amount;

    private CategoryTypeEnum type;
}
