package com.example.restaurant.service;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.dto.IngredientDto;
import com.example.restaurant.mapper.IngredientMapper;
import com.example.restaurant.repository.DishRepository;
import com.example.restaurant.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service()
public class IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    DishRepository dishRepository;

    @Autowired
    IngredientMapper mapper;

    public Optional<Ingredient> getIngredientById(Long id) {
        return ingredientRepository.findById(id);
    }

    public List<Ingredient> getAllIngredients(){
        return ingredientRepository.findAll();
    }

    public Ingredient saveIngredient(IngredientDto ingredientDto){
        Ingredient ingredient = mapper.mapToIngredient(ingredientDto);
        Dish dish = dishRepository.findById(ingredientDto.getDishId()).orElse(new Dish());
        ingredient.setDish(dish);
        return ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(Long id){
        ingredientRepository.deleteById(id);
    }
}
