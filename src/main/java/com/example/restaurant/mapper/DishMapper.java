package com.example.restaurant.mapper;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.dto.DishDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DishMapper {
    public Dish mapToDish(DishDto dishDto){
        return new Dish(
                dishDto.getId(),
                dishDto.getName(),
                dishDto.getPrice(),
                dishDto.getDescription()
        );
    }

    public DishDto mapToDishDto(Dish dish){
        return new DishDto(
                dish.getId(),
                dish.getName(),
                dish.getPrice(),
                dish.getDescription()
        );
    }

    public List<DishDto> mapToDishDtosList(List<Dish> dishes){
        return dishes.stream()
                .map(d -> new DishDto(
                        d.getId(),
                        d.getName(),
                        d.getPrice(),
                        d.getDescription()))
                .collect(Collectors.toList());
    }
}
