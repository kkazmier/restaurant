package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "dishId", referencedColumnName = "id")
//    private Dish dish;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "tableOrderId",
            referencedColumnName = "id",
            nullable = false)
    private TableOrder order;
}
