package com.example.restaurant.controller;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.service.DishService;
import com.example.restaurant.service.IngredientService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/v1/dish/")
@AllArgsConstructor
public class DishController {
    private final Logger logger = LoggerFactory.getLogger(DishController.class);

    private DishService dishService;
    private IngredientService ingredientService;

    @GetMapping("all")
    public List<Dish> getDishes(){
        List<Dish> dishes = dishService.getAllDishes();
        logger.info("Get " + dishes.size() + " dish(s)");
        return dishes;
    }

    @GetMapping("get/{id}")
    public Dish getDish(@PathVariable("id") Long id) throws ElementNotFoundException {
        logger.info("Request dish by id: " + id);
        return dishService.getDishById(id).orElseThrow(ElementNotFoundException::new);
    }

    @GetMapping("getIngredients/{id}")
    public List<Ingredient> getIngredients(@PathVariable("id") Long id) throws ElementNotFoundException{
        logger.info("Get ingredients of dish by id: " + id);
        Dish dish = dishService.getDishById(id).orElse(new Dish());
        return dish.getIngredients();
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createDish(@RequestBody Dish dish){
        logger.info("Add new dish: " + dish.getName());
        dishService.saveDish(dish);
    }

    @PostMapping(value = "addIngredient/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addIngredient(
            @RequestBody Ingredient ingredient,
            @PathVariable("id") Long id)
            throws ElementNotFoundException{
        logger.info("Try add ingredient to dish.");
        Dish dish = dishService.getDishById(id).orElseThrow(ElementNotFoundException::new);
        dish.getIngredients().add(ingredient);
        ingredient.setDish(dish);
        ingredientService.saveIngredient(ingredient);
    }

    @PutMapping(value = "addIngredient/{ingredientId}/toDish/{dishId}")
    public void addExistIngredientToDish(
            @PathVariable("ingredientId") Long ingredientId,
            @PathVariable("dishId") Long dishId)
            throws ElementNotFoundException{
        Dish dish = dishService.getDishById(dishId).orElseThrow(ElementNotFoundException::new);
        Ingredient ingredient = ingredientService.getIngredientById(ingredientId).orElseThrow(ElementNotFoundException::new);
        ingredient.setDish(dish);
        dish.getIngredients().add(ingredient);
        dishService.saveDish(dish);
        ingredientService.saveIngredient(ingredient);
        logger.info("Add " + ingredient + " to " + dish);
        logger.info("Dish: " + dish);
    }

    @PutMapping(value = "removeIngredient/{ingredientId}/fromDish/{dishId}")
    public void removeIngredientFromDish(
            @PathVariable("ingredientId") Long ingredientId,
            @PathVariable("dishId") Long dishId)
            throws ElementNotFoundException{
        Dish dish = dishService.getDishById(dishId).orElseThrow(ElementNotFoundException::new);
        Ingredient ingredient = ingredientService.getIngredientById(ingredientId).orElseThrow(ElementNotFoundException::new);
        dish.getIngredients().remove(ingredient);
        ingredient.setDish(null);
        dishService.saveDish(dish);
        ingredientService.saveIngredient(ingredient);
        logger.info("Remove " + ingredient + " from " + dish);
    }

    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dish updateDish(@RequestBody Dish dish){
        logger.info("Update dish: " + dish.getName() + ", id = "+ dish.getId());
        return dishService.saveDish(dish);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteDish(@PathVariable("id") Long id){
        logger.info("Try to delete dish by id = " + id);
        dishService.deleteDish(id);
    }
}
