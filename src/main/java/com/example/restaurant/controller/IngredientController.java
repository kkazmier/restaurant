package com.example.restaurant.controller;

import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.dto.IngredientDto;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.mapper.IngredientMapper;
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
    IngredientService service;

    @Autowired
    IngredientMapper mapper;

    @GetMapping("all")
    public List<IngredientDto> getIngredients(){
        List<Ingredient> ingredients = service.getAllIngredients();
        logger.info("Get " + ingredients.size() + " ingredient(s)");
        return mapper.mapToIngredientDtoList(ingredients);
    }

    @GetMapping("get/{id}")
    public IngredientDto getIngredient(@PathVariable("id") Long id) throws ElementNotFoundException{
        logger.info("Request ingredient by id: " + id);
        return mapper.mapToIngredientDto(service.getIngredientById(id).orElseThrow(ElementNotFoundException::new));
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createIngredient(@RequestBody IngredientDto ingredientDto){
        logger.info("Add new ingredient: " + ingredientDto.getName());
        service.saveIngredient(mapper.mapToIngredient(ingredientDto));
    }

    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public IngredientDto updateIngredient(@RequestBody IngredientDto ingredientDto){
        logger.info("Update ingredient: " + ingredientDto.getName() + ", id = "+ ingredientDto.getIngredientId());
        return mapper.mapToIngredientDto(service.saveIngredient(mapper.mapToIngredient(ingredientDto)));
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteIngredient(@PathVariable("id") Long id){
        logger.info("Try to delete ingredient by id = " + id);
        service.deleteIngredient(id);
    }
}
