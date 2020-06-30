package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ingredients")
public class Ingredient extends NamedEntity {
    @Column
    private String type;

    @Column
    private Double quantity;

    @Column(name = "measureUnit")
    private String measureUnit;

    @Column
    private Double price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "dishId",
            referencedColumnName = "id"
    )
    private Dish dish;
}
