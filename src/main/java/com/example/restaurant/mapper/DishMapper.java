package com.example.restaurant.mapper;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Order;
import com.example.restaurant.domain.dto.DishDto;
import com.example.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DishMapper {
    @Autowired
    OrderRepository orderRepository;

    public Dish mapToDish(DishDto dishDto){
        return new Dish(
                dishDto.getDishId(),
                dishDto.getName(),
                dishDto.getPrice(),
                dishDto.getDescription(),
                dishDto.getIngredients(),
                orderRepository.findById(dishDto.getOrderId()).orElse(new Order())
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
