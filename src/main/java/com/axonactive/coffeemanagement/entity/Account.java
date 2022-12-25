package com.axonactive.coffeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    @NotNull(message = "The username can't be null !!!")
    @Size(max = 100)
    private String username;

    @Column( length = 50, nullable = false)
    @NotNull(message = "The password can't be null !!!")
    @Size(max = 50)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
