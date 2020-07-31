package com.example.restaurant.domain;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.TableOrder;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.repository.TableOrderRepository;
import com.example.restaurant.service.TableOrderServiceImpl;
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

    @Before
    public void prepareDishes(){
        dishes = new ArrayList<>();
        Dish dish1 = new Dish();
        Dish dish2 = new Dish();
        Dish dish3 = new Dish();
        Dish dish4 = new Dish();
        dish1.setPrice(1.00);
        dish2.setPrice(2.00);
        dish3.setPrice(3.00);
        dish4.setPrice(4.00);
        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);
        dishes.add(dish4);
    }

    @Before
    public void prepareOrder(){
        order = new TableOrder();
        order.setId(id);
        order.setDishes(dishes);
    }

    @Test
    public void testGetTotalCost() {
        Assert.assertEquals(10, order.getTotalCost(), 0.001);
        Dish dish = new Dish();
        dish.setPrice(10.00);
        order.getDishes().add(dish);
        Assert.assertEquals(20, order.getTotalCost(), 0.001);
    }
}
