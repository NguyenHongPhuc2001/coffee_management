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
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "payment_name", length = 100, nullable = false)
    @NotNull(message = "The paymentName can't be null !!!")
    @Size(max = 100)
    private String paymentName;

    @Column(name = "payment_image")
    private String paymentImage;


    @OneToMany(mappedBy = "payment")
    private List<Bill> bills;
}
