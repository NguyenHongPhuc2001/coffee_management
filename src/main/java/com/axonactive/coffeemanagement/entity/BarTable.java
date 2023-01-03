package com.axonactive.coffeemanagement.entity;

import com.axonactive.coffeemanagement.utils.Enum.BarTableStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bar_table")
public class BarTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bar_table_id")
    private Long id;

    @Column( nullable = false, unique = true)
    @NotNull(message = "The number of bar_table can't be null !")
    @Max(100)
    private Integer number;

    @Column(name = "number_of_seat", nullable = false)
    @NotNull(message = "The numberSeat can't be null !")
    @Max(4)
    private Integer numberOfSeat;

    @Enumerated(EnumType.STRING)
    private BarTableStatusEnum status;
}
