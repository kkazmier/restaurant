package com.example.restaurant.controller;

import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.dto.IngredientDto;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.service.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ingredient/")
public class IngredientController {
    private final Logger logger = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    private IngredientService service;

    @GetMapping("all")
    public List<Ingredient> getIngredients(){
        logger.info("Get ingredient(s)");
        return service.getAllIngredients();
    }

    @GetMapping("get/{id}")
    public Ingredient getIngredient(@PathVariable("id") Long id) throws Exception {
        logger.info("Request ingredient by id: " + id);
        return service.getIngredientById(id)
                .orElseThrow(ElementNotFoundException::new);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createIngredient(@RequestBody Ingredient ingredient) throws ElementNotFoundException {
        logger.info("Add new ingredient: " + ingredient.getName());
        service.saveIngredient(ingredient);
    }

    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient) throws ElementNotFoundException {
        logger.info("Update ingredient: " + ingredient.getName() + ", id = "+ ingredient.getId());
        return service.saveIngredient(ingredient);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteIngredient(@PathVariable("id") Long id){
        logger.info("Try to delete ingredient by id = " + id);
        service.deleteIngredient(id);
    }
}
