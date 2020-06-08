package com.example.restaurant.service;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.dto.DishDto;
import com.example.restaurant.domain.dto.IngredientDto;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DishService {
    Optional<Dish> getDishById(Long id) throws ElementNotFoundException;

    List<Dish> getAllDishes();

    Dish saveDish(Dish dish);

    void deleteDish(Long id);

    List<Ingredient> getIngredients(Long id);
}
