package com.example.restaurant.repository;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DishRepository extends CrudRepository<Dish, Long> {
    List<Dish> findAll();

    Optional<Dish> findById(Long id);

    Dish save(Dish ingredient);

    void deleteById(Long id);
}
