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

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;

    public Optional<Dish> getDishById(Long id) throws ElementNotFoundException{
        return Optional.of(dishRepository.findById(id)
                .orElseThrow(ElementNotFoundException::new));
    }

    public List<Dish> getAllDishes(){
        return dishRepository.findAll();
    }

    public Dish saveDish(Dish dish){
        return dishRepository.save(dish);
    }

    public void deleteDish(Long id){
        dishRepository.deleteById(id);
    }

    public List<Ingredient> getIngredients(Long id){
        return dishRepository.findById(id).get().getIngredients();
    }
}
