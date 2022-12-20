package com.axonactive.coffeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bill_detail")
public class BillDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Null(message = "The quantity in billDetail can't be null !")
    private Integer quantity;

    @Column(nullable = false)
    @Null(message = "The total in billDetail can't be null !")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonBackReference
    private Bill bill;
}
