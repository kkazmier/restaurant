package com.example.restaurant.domain.dto.food;

import com.example.restaurant.domain.food.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DishDto {
    private Long dishId;
    private String name;
    private Double price;
    private String description;
    private List<Ingredient> ingredients;
    private Long orderId;
}
