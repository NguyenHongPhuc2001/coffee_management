package com.axonactive.coffee_management.entity;

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
    private Long accountId;

    @Column(name = "account_username",length = 100, nullable = false)
    @NotNull(message = "The accountUsername can't be null !!!")
    @Size(max = 100)
    private String accountUsername;


    @Column(name = "account_password", length = 50, nullable = false)
    @NotNull(message = "The accountPassword can't be null !!!")
    @Size(max = 50)
    private String accountPassword;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
