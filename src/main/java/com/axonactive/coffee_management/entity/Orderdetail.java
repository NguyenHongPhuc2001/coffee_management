package com.axonactive.coffee_management.entity;

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
@Table(name = "orderdetail")
public class Orderdetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderdetail_id")
    private Long orderdetailId;

    @Column(name = "quantity", length = 3, nullable = false)
    @NotNull(message = "The quantity can't be null !!!")
    @Size(max = 3)
    private Integer quantity;



    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


}
