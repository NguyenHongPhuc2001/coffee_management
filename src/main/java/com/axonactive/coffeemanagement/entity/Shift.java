package com.axonactive.coffeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shift")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shift_id")
    private Long shiftId;

    @Column(name = "shift_name", nullable = false, length = 40)
    @Size(max = 40)
    @NotNull(message = "The shiftName can't be null !!!")
    private String shiftName;

    @Column(name = "start_at", nullable = false)
    @NotNull(message = "The startAt can't be null !!!")
    private Time startAt;

    @Column(name = "end_at", nullable = false)
    @NotNull(message = "The endAt can't be null !!!")
    private Time endAt;


    @OneToMany(mappedBy = "shift")
    private List<WorkSchedule> workSchedules;
}
