package com.axonactive.coffeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    @Column(nullable = false, length = 100)
    @Size(max = 100)
    @NotNull(message = "The name of food can't be null !")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "The current price of food can't be null !")
    private Double price;

    private String image;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;
}