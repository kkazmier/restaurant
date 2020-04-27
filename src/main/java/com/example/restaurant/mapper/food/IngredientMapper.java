package com.example.restaurant.mapper.food;

import com.example.restaurant.domain.food.Dish;
import com.example.restaurant.domain.food.Ingredient;
import com.example.restaurant.domain.dto.food.IngredientDto;
import com.example.restaurant.service.food.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IngredientMapper {
    @Autowired
    DishService dishService;

    @Autowired
    DishMapper dishMapper;

    public Ingredient mapToIngredient(IngredientDto ingredientDto){
        return new Ingredient(
                ingredientDto.getIngredientId(),
                ingredientDto.getName(),
                ingredientDto.getType(),
                ingredientDto.getQuantity(),
                ingredientDto.getMeasureUnit(),
                ingredientDto.getPrice(),
                ingredientDto.getDescription(),
                dishService.getDishById(ingredientDto.getDishId()).orElse(new Dish())
        );
    }

    public IngredientDto mapToIngredientDto(Ingredient ingredient){
        return new IngredientDto(
                ingredient.getIngredientId(),
                ingredient.getName(),
                ingredient.getType(),
                ingredient.getQuantity(),
                ingredient.getMeasureUnit(),
                ingredient.getPrice(),
                ingredient.getDescription(),
                ingredient.getDish().getDishId()
        );
    }

    public List<IngredientDto> mapToIngredientDtoList(List<Ingredient> ingredients){
        return ingredients.stream()
                .map(i -> new IngredientDto(
                        i.getIngredientId(),
                        i.getName(),
                        i.getType(),
                        i.getQuantity(),
                        i.getMeasureUnit(),
                        i.getPrice(),
                        i.getDescription(),
                        i.getDish().getDishId()))
                .collect(Collectors.toList());
    }
}
