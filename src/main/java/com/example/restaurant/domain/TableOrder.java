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
@Table(name = "table_orders")
public class TableOrder extends BaseOrder {
    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "join_table_orders_dish_quantities",
            joinColumns = {@JoinColumn(name = "dish_quantity_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name =  "table_order_id", referencedColumnName = "id")})
    List<Dish> dishes = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "id",
            nullable = false)
    private Employee employee;
}
