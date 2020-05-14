package com.example.restaurant.controller;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.dto.DishDto;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.mapper.food.DishMapper;
import com.example.restaurant.service.food.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/dish/")
public class DishController {
    private final Logger logger = LoggerFactory.getLogger(DishController.class);

    @Autowired
    DishService service;

    @Autowired
    DishMapper mapper;

    @GetMapping("all")
    public List<DishDto> getDishes(){
        List<Dish> dishes = service.getAllDishes();
        logger.info("Get " + dishes.size() + " dish(s)");
        return mapper.mapToDishDtosList(dishes);
    }

    @GetMapping("get/{id}")
    public DishDto getDish(@PathVariable("id") Long id) throws ElementNotFoundException {
        logger.info("Request dish by id: " + id);
        return mapper.mapToDishDto(service.getDishById(id).orElseThrow(ElementNotFoundException::new));
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createDish(@RequestBody DishDto dishDto){
        logger.info("Add new dish: " + dishDto.getName());
        service.saveDish(mapper.mapToDish(dishDto));
    }

    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public DishDto updateDish(@RequestBody DishDto dishDto){
        logger.info("Update dish: " + dishDto.getName() + ", id = "+ dishDto.getDishId());
        return mapper.mapToDishDto(service.saveDish(mapper.mapToDish(dishDto)));
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteDish(@PathVariable("id") Long id){
        logger.info("Try to delete dish by id = " + id);
        service.deleteDish(id);
    }
}
