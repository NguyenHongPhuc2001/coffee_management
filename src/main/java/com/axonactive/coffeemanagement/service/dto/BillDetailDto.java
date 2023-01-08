package com.axonactive.coffeemanagement.service.dto;

import com.axonactive.coffeemanagement.entity.Bill;
import com.axonactive.coffeemanagement.entity.Drink;
import com.axonactive.coffeemanagement.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDetailDto {

    private Integer quantity;

    private Double total;

    private Bill bill;

    private Food food;

    private Drink drink;
}
