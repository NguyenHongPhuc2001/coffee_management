package com.axonactive.coffeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_phone", length = 10, nullable = false)
    @NotNull(message = "The customerPhone can't be null !!!")
    @Size(max = 10)
    private String customerPhone;


    @Column(name = "customer_name", length = 100)
    @Size(max = 100)
    private String customerName;


    @Column(name = "customer_address")
    private String customerAddress;


    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
