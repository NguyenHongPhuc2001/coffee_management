package com.axonactive.coffeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fad")
public class FoodAndDrink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fad_id")
    private Long fadId;

    @Column(name = "fad_name", length = 100, nullable = false)
    @NotNull(message = "The fadName can't be null !!!")
    @Size(max = 100)
    private String fadName;


    @Column(name = "fad_price", nullable = false)
    @NotNull(message = "The fadPrice can't be null !!!")
    private BigDecimal fadPrice;


    @Column(name = "fad_image")
    private String fadImage;

    @Column(name = "fad_description")
    private String fadDescription;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



}
