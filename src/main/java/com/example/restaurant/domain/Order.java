package com.example.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column
    private String status;

    @Column
    private String description;

    @Column
    private boolean isTakeAway;

    @OneToMany(
            targetEntity = Dish.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Dish> dishes = new ArrayList<>();
}
