package com.example.restaurant.service;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.exception.ElementNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DishService {
    Optional<Dish> getDishById(Long id) throws ElementNotFoundException;

    List<Dish> getAllDishes();

    Dish saveDish(Dish dish);

    void deleteDish(Long id);

    List<Ingredient> getIngredients(Long id);
}
