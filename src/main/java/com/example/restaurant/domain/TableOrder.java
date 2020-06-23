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
@Table(name = "tableOrders")
public class TableOrder extends BaseOrder {
    //@JsonManagedReference
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "tableOrdersDishQuantities",
            joinColumns = {@JoinColumn(name = "dishQuantityId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name =  "tableOrderId", referencedColumnName = "id")})
    List<Dish> dishes = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "employeeId",
            referencedColumnName = "id",
            nullable = false)
    private Employee employee = new Employee();
}
