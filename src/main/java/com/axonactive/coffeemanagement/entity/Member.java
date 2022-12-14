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
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "member_phone", length = 10, nullable = false)
    @NotNull(message = "The memberPhone can't be null !!!")
    @Size(max = 10)
    private String memberPhone;


    @Column(name = "member_name", length = 100)
    @Size(max = 100)
    private String memberName;


    @Column(name = "bonus_point")
    private Integer bonusPoint;


    @OneToMany(mappedBy = "member")
    private List<Booking> bookings;


    @OneToMany(mappedBy = "member")
    private List<Bill> bills;
}
