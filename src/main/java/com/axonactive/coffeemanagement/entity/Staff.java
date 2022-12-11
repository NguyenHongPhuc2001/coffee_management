package com.axonactive.coffeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staff")
public class Staff {
    private Long staffId;
    private String staffName;
    private String staffAge;
    private String staffAddress;
    private String staffImage;
    private String staffPhone;
    private String staffSex;
}
