package com.example.restaurant.mapper;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.dto.DishDto;
import com.example.restaurant.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DishMapper {

    private final OrderService orderService;

    public Dish mapToDish(DishDto dishDto){
        return new Dish(
                dishDto.getDishId(),
                dishDto.getName(),
                dishDto.getPrice(),
                dishDto.getDescription(),
                dishDto.getIngredients(),
                orderService.getOrderById(dishDto.getOrderId()).orElse(new Order())
        );
    }

    public DishDto mapToDishDto(Dish dish){
        return new DishDto(
                dish.getDishId(),
                dish.getName(),
                dish.getPrice(),
                dish.getDescription(),
                dish.getIngredients(),
                dish.getOrder().getOrderId()
        );
    }

    public List<DishDto> mapToDishDtosList(List<Dish> dishes){
        return dishes.stream()
                .map(d -> new DishDto(
                        d.getDishId(),
                        d.getName(),
                        d.getPrice(),
                        d.getDescription(),
                        d.getIngredients(),
                        d.getOrder().getOrderId()))
                .collect(Collectors.toList());
    }
}
