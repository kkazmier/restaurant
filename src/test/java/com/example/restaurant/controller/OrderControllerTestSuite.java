package com.example.restaurant.controller;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.Order;
import com.example.restaurant.domain.dto.DishDto;
import com.example.restaurant.domain.dto.OrderDto;
import com.example.restaurant.service.DishService;
import com.example.restaurant.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @MockBean
    private DishService dishService;

    @MockBean
    private OrderMapper orderMapper;

    @Test
    public void testCreateNewOrder() throws Exception{
        Order order = orderMapper.mapToOrder(new OrderDto(
                1L, "in progress, ", LocalDateTime.now(), LocalDateTime.now(),"",
                false, new ArrayList<Dish>()));

        when(orderService.saveOrder(any())).thenReturn(order);
        mockMvc.perform(post("/v1/order/create").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteOrder() throws Exception {
        Order order = orderMapper.mapToOrder(new OrderDto(
                1L, "in progress, ", LocalDateTime.now(), LocalDateTime.now(),"",
                false, new ArrayList<Dish>()));

        mockMvc.perform(delete("/v1/order/delete/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddDishToOrder() throws Exception {
        DishDto dish1 = new DishDto(1L, "dish1", 10.00, "", new ArrayList<Ingredient>(), null);
        DishDto dish2 = new DishDto(2L, "dish1", 20.00, "", new ArrayList<Ingredient>(), null);
        Order order = orderMapper.mapToOrder(new OrderDto(
                1L, "in progress, ", LocalDateTime.now(), LocalDateTime.now(),"",
                false, new ArrayList<Dish>()));

        when(orderService.getOrderById(1L)).thenReturn(java.util.Optional.ofNullable(order));
        mockMvc.perform(post("/v1/order/addDish/1/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
