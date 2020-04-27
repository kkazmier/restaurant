package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long dishId;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private String description;

    //@JsonManagedReference
    @OneToMany(
            targetEntity = Ingredient.class,
            mappedBy = "dish",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<Ingredient> ingredients = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
