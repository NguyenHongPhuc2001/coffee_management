package com.axonactive.coffeemanagement.entity;

import com.axonactive.coffeemanagement.utils.Enum.GenderEnum;
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
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Long staffId;

    @Column(name = "staff_name", nullable = false, length = 100)
    @Size(max = 100)
    @NotNull(message = "The staffName can't be null !!!")
    private String staffName;

    @Column(name = "staff_age", nullable = false, length = 2)
    @Size(max = 2)
    @NotNull(message = "The staffAge can't be null !!!")
    private Integer staffAge;

    @Column(name = "staff_address", length = 200)
    @Size(max = 200)
    private String staffAddress;

    @Column(name = "staff_image")
    private String staffImage;

    @Column(name = "staff_phone",length = 10, nullable = false)
    @NotNull(message = "The staffPhone can't be null !!!")
    @Size(max = 10)
    private String staffPhone;

    @Column(name = "staff_gender", nullable = false)
    @NotNull(message = "The staffSex can't be null !!!")
    @Enumerated(value = EnumType.STRING)
    private GenderEnum staffGender;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "staff")
    private List<WorkSchedule> workSchedules;

    @OneToMany(mappedBy = "staff")
    private List<Bill> bills;

}
