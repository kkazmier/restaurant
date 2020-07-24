package com.example.restaurant.service;

import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.repository.IngredientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository repository;

    public IngredientServiceImpl(IngredientRepository repository) {
        this.repository = repository;
    }

    public Optional<Ingredient> getIngredientById(Long id) throws ElementNotFoundException {
        return Optional.of(repository.findById(id)
                .orElseThrow(ElementNotFoundException::new));
    }

    public List<Ingredient> getAllIngredients(){
        return repository.findAll();
    }

    public List<Ingredient> getIngredientsNotDependToDish() {
        return repository.getIngredientsNotDependToDish();
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public void deleteIngredient(Long id){
        repository.deleteIngredientById(id);
    }
}
