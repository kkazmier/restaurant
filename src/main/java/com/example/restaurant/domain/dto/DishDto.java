package com.example.restaurant.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DishDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
}
