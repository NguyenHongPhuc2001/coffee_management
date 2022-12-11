package com.axonactive.coffeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@javax.persistence.Table (name = "table")
public class Table {
    private Long tableId;
    private Integer tableName;
    private boolean tableStatus;
    private Integer tableSeats;
}
