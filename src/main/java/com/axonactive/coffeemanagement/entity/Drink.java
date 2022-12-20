package com.axonactive.coffeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drink")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    @Size(max = 100)
    @Null(message = "The name of drink can't be null !")
    private String name;

    @Column(nullable = false)
    @Null(message = "The current price of drink can't be null !")
    private Double currentPrice;

    @Column(nullable = false)
    @Null(message = "The old price of drink can't be null !")
    private Double oldPrice;

    private String image;

    private String description;

}
