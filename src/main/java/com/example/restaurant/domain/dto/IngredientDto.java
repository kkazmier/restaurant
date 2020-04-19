package com.example.restaurant.domain.dto;

import com.example.restaurant.domain.Dish;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IngredientDto {
    private Long ingredientId;
    private String name;
    private String type;
    private Double quantity;
    private String measureUnit;
    private String description;
    private Dish dish;
}
