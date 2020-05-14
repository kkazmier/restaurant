package com.example.restaurant.controller;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Order;
import com.example.restaurant.domain.dto.OrderDto;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.mapper.OrderMapper;
import com.example.restaurant.service.DishService;
import com.example.restaurant.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order/")
public class OrderController {
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @Autowired
    DishService dishService;

    @Autowired
    OrderMapper orderMapper;

    @GetMapping("all")
    public List<OrderDto> getOrders(){
        List<Order> orders = orderService.getAllOrders();
        logger.info("Get " + orders.size() + " dish(s)");
        return orderMapper.getMapToOrderDtosList(orders);
    }

    @GetMapping("get/{id}")
    public OrderDto getOrder(@PathVariable("id") Long id) throws ElementNotFoundException {
        logger.info("Request order by id: " + id);
        return orderMapper.mapToOrderDto(orderService.getOrderById(id).orElseThrow(ElementNotFoundException::new));
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto){
        logger.info("Add new order have id: " + orderDto.getOrderId());
        orderService.saveOrder(orderMapper.mapToOrder(orderDto));
    }

    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto){
        logger.info("Update order have id: " + orderDto.getOrderId());
        return orderMapper.mapToOrderDto(orderService.saveOrder(orderMapper.mapToOrder(orderDto)));
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteOrder(@PathVariable("id") Long id){
        logger.info("Try to delete order by id = " + id);
        orderService.deleteOrder(id);
    }

    @PutMapping(value = "addDish/{orderId}/{dishId}")
    public void addDish(@PathVariable("orderId") Long orderId, @PathVariable("dishId") Long dishId){
        Order order = orderService.getOrderById(orderId).orElseGet(null);
        Dish dish = dishService.getDishById(dishId).orElseGet(null);

        if((order != null) && (dish != null)){
            logger.info("Order or dish have given id doesnt exist.");
        } else {
            order.getDishes().add(dish);
            orderService.saveOrder(order);
            logger.info("Add " + dish.getName() + " to order.");
        }
    }
}
