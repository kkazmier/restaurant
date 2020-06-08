package com.example.restaurant.repository;

import com.example.restaurant.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    List<Ingredient> findAll();

    Optional<Ingredient> findById(Long id);

    Ingredient save(Ingredient ingredient);

    void deleteById(Long id);
}
