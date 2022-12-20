package com.axonactive.coffeemanagement.entity;

import com.axonactive.coffeemanagement.utils.Enum.BarTableStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Long id;

    @Column( nullable = false, unique = true, length = 2)
    @Null(message = "The number of bar_table can't be null !")
    @Size(max = 2)
    private Integer number;

    @Column(name = "number_seat", nullable = false, length = 2)
    @Size(max = 2)
    @Null(message = "The numberSeat can't be null !")
    private Integer numberSeat;


    @Enumerated(EnumType.STRING)
    private BarTableStatusEnum status;


}
