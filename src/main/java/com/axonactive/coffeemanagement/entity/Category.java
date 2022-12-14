package com.axonactive.coffeemanagement.entity;


import com.axonactive.coffeemanagement.utils.Enum.CategoryTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(length = 100, nullable = false)
    @NotNull(message = "The categoryName can't be null !!!")
    @Size(max = 100)
    private String name;

    @Max(200)
    private Integer amount;

    @Enumerated(EnumType.STRING)
    private CategoryTypeEnum type;

//    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
//    private List<Food> foods;
//
//    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
//    private List<Drink> drinks;
}
