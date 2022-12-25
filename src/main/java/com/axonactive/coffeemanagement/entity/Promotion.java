package com.axonactive.coffeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @Column(name = "promotion_id")
    private Long id;

    @Column(nullable = false, length = 3)
    @Size(max = 3)
    @NotNull(message = "The bonus of promotion can't be null !")
    private Integer bonus;

    @Column(nullable = false)
    @NotNull(message = "The name of promotion can't be null !")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "The promotionValue can't null !")
    private Double promotionValue;

    @CreationTimestamp
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;
}
