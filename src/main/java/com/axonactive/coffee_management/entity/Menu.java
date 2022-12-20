package com.axonactive.coffeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "menu_name", length = 100, nullable = false)
    @NotNull(message = "The menuName can't be null !!!")
    @Size(max = 100)
    private String menuName;


    @Column(name = "menu_price", nullable = false)
    @NotNull(message = "The menuPrice can't be null !!!")
    private BigDecimal menuPrice;


    @Column(name = "menu_image")
    private String menuImage;

    @Column(name = "menu_description")
    private String menuDescription;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @OneToMany(mappedBy = "menu")
    private List<Orderdetail> orderdetails;
}
