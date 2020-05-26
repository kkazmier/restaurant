package com.example.restaurant.domain;

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
public class Dish extends NamedEntity {
    @Column
    private Double price;

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
