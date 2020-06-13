package com.example.restaurant.service;

import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.exception.ElementNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IngredientService {
    Optional<Ingredient> getIngredientById(Long id) throws ElementNotFoundException;

    List<Ingredient> getAllIngredients();

    Ingredient saveIngredient(Ingredient ingredient);

    void deleteIngredient(Long id);
}
