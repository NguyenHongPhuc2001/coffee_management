package com.axonactive.coffeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 3)
    @Size(max = 3)
    @Null(message = "The bonus of promotion can't be null !")
    private Integer bonus;

    @Column(nullable = false)
    @Null(message = "The name of promotion can't be null !")
    private String name;

    @Column(nullable = false)
    @Null(message = "The promotionValue can't null !")
    private Double promotionValue;

    @CreationTimestamp
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;
}
