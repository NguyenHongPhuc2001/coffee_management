package com.axonactive.coffeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bill_detail")
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_detail_id")
    private Long billDetailId;

    @Column(name = "quantity", length = 3, nullable = false)
    @NotNull(message = "The quantity can't be null !!!")
    @Size(max = 3)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private FoodAndDrink foodAndDrink;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;


}
