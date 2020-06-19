package com.example.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "dishQuantities")
public class DishQuantity extends BaseEntity {
    @Column
    private Integer quantity;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "dishId", referencedColumnName = "id")
    private Dish dish;
}
