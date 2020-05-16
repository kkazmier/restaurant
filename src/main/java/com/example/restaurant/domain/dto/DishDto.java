package com.example.restaurant.domain.dto;

import com.example.restaurant.domain.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {
    private Long dishId;
    private String name;
    private Double price;
    private String description;
    private List<Ingredient> ingredients;
    private Long orderId;
}
