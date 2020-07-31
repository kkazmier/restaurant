package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tableOrders")
public class TableOrder extends BaseOrder {
    @JsonManagedReference
    @OneToMany(
            targetEntity = Dish.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Dish> dishes = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "employeeId",
            referencedColumnName = "id")
            //nullable = false)
    private Employee employee = new Employee();

    @Override
    public Double getTotalCost() {
        return dishes.stream()
                .map(Dish::getPrice)
                .reduce(0.00, Double::sum);
    }
}
