package com.example.restaurant.mapper;

import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.dto.IngredientDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IngredientMapper {
    public Ingredient mapToIngredient(IngredientDto ingredientDto){
        return new Ingredient(
                ingredientDto.getIngredientId(),
                ingredientDto.getName(),
                ingredientDto.getType(),
                ingredientDto.getQuantity(),
                ingredientDto.getMeasureUnit(),
                ingredientDto.getDescription(),
                ingredientDto.getDish()
        );
    }

    public IngredientDto mapToIngredientDto(Ingredient ingredient){
        return new IngredientDto(
                ingredient.getIngredientId(),
                ingredient.getName(),
                ingredient.getType(),
                ingredient.getQuantity(),
                ingredient.getMeasureUnit(),
                ingredient.getDescription(),
                ingredient.getDish()
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
                        i.getDescription(),
                        i.getDish()))
                .collect(Collectors.toList());
    }
}
