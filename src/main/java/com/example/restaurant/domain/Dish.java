package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    private String type;

    @Column
    private Double price;

    @JsonManagedReference
    @OneToMany(
            targetEntity = Ingredient.class,
            mappedBy = "dish",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Ingredient> ingredients = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "dishes")
    private List<TableOrder> orders;
}
