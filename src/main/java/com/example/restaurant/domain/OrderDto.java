package com.example.restaurant.domain;

import com.example.restaurant.domain.Dish;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class OrderDto {
    private Long orderId;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime closeTime;
    private String description;
    private boolean isTakeAway;
    private List<Dish> dishes;
}
