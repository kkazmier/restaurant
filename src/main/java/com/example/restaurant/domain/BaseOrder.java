package com.example.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseOrder extends BaseEntity {
    @Column
    private LocalDateTime createTime;

    @Column
    private LocalDateTime closeTime;

    @Column
    private String status;

    @Column
    private String description;

    @OneToMany(
            targetEntity = Dish.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Dish> dishes = new ArrayList<>();
}
