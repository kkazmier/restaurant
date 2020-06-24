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
            targetEntity = DishQuantity.class,
            //mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<DishQuantity> dishes = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "employeeId",
            referencedColumnName = "id")
            //nullable = false)
    private Employee employee = new Employee();
}
