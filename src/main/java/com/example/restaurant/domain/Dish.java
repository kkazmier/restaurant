package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dishes")
public class Dish extends NamedEntity {
    @Column
    private String type;

    @Column
    private BigDecimal price;

    @ManyToMany(mappedBy = "dishes")
    @JsonIgnoreProperties("dishes")
    List<TableOrder> orders = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(
            targetEntity = Ingredient.class,
            mappedBy = "dish",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Ingredient> ingredients = new ArrayList<>();


}
