package com.axonactive.coffeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    private Long promotionId;

    @Column(name = "promotion_name", nullable = false, unique = true, length = 150)
    @NotNull(message = "The promotionName can't be null !!!")
    @Size(max = 150)
    private String promotionName;

    @Column(name = "promotion_value", nullable = false)
    @NotNull(message = "The promotionValue can't be null !!!")
    private BigDecimal promotionValue;

    @Column(name = "bonus_request")
    private Integer bonusRequest;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @OneToMany(mappedBy = "promotion")
    private List<Bill> bills;

}
