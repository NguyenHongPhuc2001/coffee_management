package com.axonactive.coffeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_schedule")
public class WorkSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_schedule_id")
    private Long workScheduleId;

    @Column(name = "work_date", nullable = false)
    @NotNull(message = "The workDate can't be null !!!")
    private Date workDate;


    @ManyToOne
    @JoinColumn(name = "shift_id")
    private Shift shift;


    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;


}
