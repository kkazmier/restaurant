package com.example.restaurant.service;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    @Autowired
    DishRepository dishRepository;

    @Autowired
    DishService dishService;

    public Optional<Dish> getDishById(Long id) {
        return dishRepository.findById(id);
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
}
