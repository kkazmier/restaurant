package com.example.restaurant.domain.dto;

import com.example.restaurant.domain.Dish;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OrderDto {
    private Long orderId;
    private String status;
    private String description;
    private boolean isTakeAway;
    private List<Dish> dishes;
}
