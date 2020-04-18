package com.example.restaurant.service;

import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.mapper.IngredientMapper;
import com.example.restaurant.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    IngredientRepository repository;

    @Autowired
    IngredientMapper mapper;

    public Optional<Ingredient> getIngredientById(Long id) {
        return repository.findById(id);
    }

    public List<Ingredient> getAllIngredients(){
        return repository.findAll();
    }

    public Ingredient saveIngredient(Ingredient ingredient){
        return repository.save(ingredient);
    }

    public void deleteIngredient(Long id){
        repository.deleteById(id);
    }
}
