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

import java.util.List;

@RestController
@RequestMapping("/v1/dish/")
@AllArgsConstructor
public class DishController {
    private final Logger logger = LoggerFactory.getLogger(DishController.class);

    private final DishService dishService;
    private final IngredientService ingredientService;

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

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createDish(@RequestBody Dish dish){
        logger.info("Add new dish: " + dish.getName());
        dishService.saveDish(dish);
    }

    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dish updateDish(@RequestBody Dish dish){
        logger.info("Update dish: " + dish.getName() + ", id = "+ dish.getId());
        return dishService.saveDish(dish);
    }

    @PutMapping(value = "addIngr/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dish addIngredient(@RequestBody Ingredient ingredient, @PathVariable("id") Long id) throws ElementNotFoundException {
        Dish dish = dishService.getDishById(id).orElseThrow(ElementNotFoundException::new);
        ingredientService.saveIngredient(ingredient);
        dish.getIngredients().add(ingredient);
        logger.info("Add " + ingredient.getName() + " to " + dish.getName() + " .");
        return dishService.saveDish(dish);

    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteDish(@PathVariable("id") Long id){
        logger.info("Try to delete dish by id = " + id);
        dishService.deleteDish(id);
    }

    @GetMapping("get/{id}/ingredients")
    public List<Ingredient> getIngredients(@PathVariable("id") Long id) {
        logger.info("Request ingredients dish by id: " + id);
        return dishService.getIngredients(id);
    }
}
