package com.example.restaurant.mapper;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.dto.DishDto;
import com.example.restaurant.domain.dto.IngredientDto;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class IngredientMapper {

    private final DishService dishService;
    private final DishMapper dishMapper;

    public Ingredient mapToIngredient(IngredientDto ingredientDto) throws ElementNotFoundException {
        return new Ingredient(
                ingredientDto.getIngredientId(),
                ingredientDto.getName(),
                ingredientDto.getType(),
                ingredientDto.getQuantity(),
                ingredientDto.getMeasureUnit(),
                ingredientDto.getPrice(),
                ingredientDto.getDescription(),
                dishMapper.mapToDish(dishService.getDishById(ingredientDto.getDishId()).orElseThrow(ElementNotFoundException::new))
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
