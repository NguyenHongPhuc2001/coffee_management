package com.axonactive.coffee_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@javax.persistence.Table (name = "table")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Long tableId;

    @Column(name = "table_number", length = 3, nullable = false)
    @NotNull(message = "The tableName can't be null !!!")
    @Size(max = 3)
    private Integer tableNumber;


    @Column(name = "table_status")
    private Integer tableStatus;


    @Column(name = "table_seats", length = 2,nullable = false)
    @NotNull(message = "The tableSeats can't be null !!!")
    @Size(max = 2)
    private Integer tableSeats;


    @OneToMany(mappedBy = "table")
    private List<Order> orders;
}
