package com.example.restaurant.repository.food;

import com.example.restaurant.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Transactional
@Repository()
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    @Override
    List<Ingredient> findAll();

    @Override
    Optional<Ingredient> findById(Long id);

    @Override
    Ingredient save(Ingredient ingredient);

    @Override
    void deleteById(Long id);
}
