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
    DishRepository repository;

    @Autowired
    DishService service;

    public Optional<Dish> getDishById(Long id) {
        return repository.findById(id);
    }

    public List<Dish> getAllDishes(){
        return repository.findAll();
    }

    public Dish saveDish(Dish ingredient){
        return repository.save(ingredient);
    }

    public void deleteDish(Long id){
        repository.deleteById(id);
    }
}
