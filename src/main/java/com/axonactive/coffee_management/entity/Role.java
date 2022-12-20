package com.axonactive.coffee_management.entity;

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
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name", length = 100, nullable = false)
    @NotNull(message = "The roleName can't be null !!!")
    @Size(max = 100)
    private String roleName;

    @Column(name = "role_description")
    private String roleDescription;


    @OneToMany(mappedBy = "role")
    private List<Account> accounts;
}
