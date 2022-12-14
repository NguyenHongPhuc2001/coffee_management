package com.axonactive.coffeemanagement.entity;

import com.axonactive.coffeemanagement.utils.Enum.TableStatusEnum;
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
@Table (name = "bar_table")
public class BarTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bar_table_id")
    private Long barTableId;

    @Column(name = "bar_table_number", length = 3, nullable = false)
    @NotNull(message = "The barTableName can't be null !!!")
    @Size(max = 3)
    private Integer barTableNumber;

    @Enumerated(value = EnumType.STRING)
    private TableStatusEnum barTableStatus;

    @Column(name = "bar_table_seat", length = 2,nullable = false)
    @NotNull(message = "The barTableSeat can't be null !!!")
    @Size(max = 2)
    private Integer barTableSeat;


    @OneToMany(mappedBy = "barTable")
    private List<BookingDetail> bookingDetails;


    @OneToMany(mappedBy = "barTable")
    private List<Bill> bills;
}
