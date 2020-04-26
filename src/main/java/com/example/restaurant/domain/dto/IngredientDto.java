package com.example.restaurant.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {
    private Long ingredientId;
    private String name;
    private String type;
    private Double quantity;
    private String measureUnit;
    private String description;
    private Long dishId;
}
