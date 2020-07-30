package com.example.restaurant.service;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.TableOrder;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.repository.TableOrderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TableOrderTestSuite {
    private List<Dish> dishes;
    private TableOrder order;
    private static final Long id = 1l;

    @InjectMocks
    private TableOrderServiceImpl tableOrderService;

    @Mock
    private TableOrderRepository tableOrderRepository;

    @Before
    public void prepareDishes(){
        dishes = new ArrayList<>();
        Dish dish = new Dish();
        dish.setPrice(1.00);
        dishes.add(dish);
        dish.setPrice(2.00);
        dishes.add(dish);
        dish.setPrice(3.00);
        dishes.add(dish);
        dish.setPrice(4.00);
        dishes.add(dish);
    }

    @Before
    public void prepareOrder(){
        order = new TableOrder();
        order.setId(id);
        order.setDishes(dishes);
        tableOrderRepository.save(order);
    }

}
