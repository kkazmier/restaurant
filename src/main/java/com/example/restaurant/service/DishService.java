package com.example.restaurant.service;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.dto.DishDto;
import com.example.restaurant.domain.dto.IngredientDto;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.mapper.DishMapper;
import com.example.restaurant.mapper.IngredientMapper;
import com.example.restaurant.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;

    private final DishMapper dishMapper;

    private final IngredientMapper ingredientMapper;

    public Optional<DishDto> getDishById(Long id) throws ElementNotFoundException{
        return Optional.of(dishMapper.mapToDishDto(dishRepository.findById(id).orElseThrow(ElementNotFoundException::new)));
    }

    public List<DishDto> getAllDishes(){
        return dishMapper.mapToDishDtosList(dishRepository.findAll());
    }

    public Dish saveDish(DishDto dish){
        return dishRepository.save(dishMapper.mapToDish(dish));
    }

    public void deleteDish(Long id){
        dishRepository.deleteById(id);
    }

    public List<IngredientDto> getIngredients(Long id){
        return ingredientMapper.mapToIngredientDtoList(dishRepository.findById(id).get().getIngredients());
    }
}
