package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tableOrders")
public class TableOrder extends BaseOrder {
    @ManyToMany
    @JoinTable(
            name = "tableOrdersDishes",
            joinColumns = @JoinColumn(name = "dishId"),
            inverseJoinColumns = @JoinColumn(name = "tableOrderId"))
    @JsonIgnoreProperties("orders")
    List<Dish> dishes = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "employeeId",
            referencedColumnName = "id")
            //nullable = false)
    private Employee employee = new Employee();

    @Override
    public BigDecimal getTotalCost() {
        return dishes.stream()
                .map(Dish::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
