package com.example.restaurant.repository;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Transactional
@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {
    @Override
    List<Dish> findAll();

    @Override
    Optional<Dish> findById(Long id);

    @Override
    Dish save(Dish ingredient);

    @Override
    void deleteById(Long id);
}
