package com.example.restaurant.controller;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.dto.IngredientDto;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.service.DishService;
import com.example.restaurant.service.IngredientService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ingredient/")
@AllArgsConstructor
public class IngredientController {
    private final Logger logger = LoggerFactory.getLogger(IngredientController.class);

    private IngredientService ingredientService;
    private DishService dishService;

    @GetMapping("all")
    public List<Ingredient> getIngredients(){
        logger.info("Get ingredient(s)");
        return ingredientService.getAllIngredients();
    }

    @GetMapping("get/{id}")
    public Ingredient getIngredient(@PathVariable("id") Long id) throws Exception {
        logger.info("Request ingredient by id: " + id);
        return ingredientService.getIngredientById(id)
                .orElseThrow(ElementNotFoundException::new);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createIngredient(@RequestBody Ingredient ingredient) throws ElementNotFoundException {
        logger.info("Add new ingredient: " + ingredient.getName());
        ingredientService.saveIngredient(ingredient);
    }

    @PostMapping(value = "create/{dish_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createIngredient(@PathVariable("dish_id") Long dishId, @RequestBody Ingredient ingredient) throws ElementNotFoundException {
        Dish dish = dishService.getDishById(dishId).orElseThrow(ElementNotFoundException::new);
        dish.getIngredients().add(ingredient);
        ingredient.setDish(dish);
        logger.info("Add new ingredient: " + ingredient.getName());
        ingredientService.saveIngredient(ingredient);
        dishService.saveDish(dish);
    }

    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient) throws ElementNotFoundException {
        logger.info("Update ingredient: " + ingredient.getName() + ", id = "+ ingredient.getId());
        return ingredientService.saveIngredient(ingredient);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteIngredient(@PathVariable("id") Long id){
        logger.info("Try to delete ingredient by id = " + id);
        ingredientService.deleteIngredient(id);
    }
}
