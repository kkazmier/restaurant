package com.example.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingredientId;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private Double quantity;

    @Column
    private String measureUnit;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;
}
