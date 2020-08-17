package com.example.restaurant.controller;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.TableOrder;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.service.DishService;
import com.example.restaurant.service.TableOrderService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/tableOrder/")
@AllArgsConstructor
public class TableOrderController {
    private final Logger logger = LoggerFactory.getLogger(TableOrderController.class);

    private TableOrderService tableOrderService;
    private DishService dishService;

    @GetMapping(value = "all")
    public List<TableOrder> getAllOrders(){
        logger.info("Try to get all orders.");
        return tableOrderService.getAllTableOrders();
    }

    @GetMapping("get/{id}")
    public TableOrder getOrder(@PathVariable("id") Long id) throws ElementNotFoundException{
        return tableOrderService.getTableOrderById(id).orElseThrow(ElementNotFoundException::new);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTableOrder(@RequestBody TableOrder tableOrder) throws Exception {
        logger.info("Try to create new table order");
        if(tableOrderService.isTableOrderExist(tableOrder.getId())){
            return ResponseEntity.badRequest().body("Order with given id already exist.");
        }
        TableOrder result = tableOrderService.saveTableOrder(tableOrder);
        logger.info("Create new table order (id = " + result.getId() + ")");
        return ResponseEntity.created(new URI("/v1/tableOrder/create")).body(result);
    }

    @PostMapping(value = "addDish/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addDish(
            @RequestParam("id") Long id,
            @RequestBody Dish dish)
            throws Exception {
        logger.info("Try add dish to table order");
        TableOrder order = tableOrderService.getTableOrderById(id).orElseThrow(Exception::new);
        dish.getOrders().add(order);
        order.getDishes().add(dish);
        tableOrderService.saveTableOrder(order);
        dishService.saveDish(dish);
    }

    @PutMapping(value = "addDish/{dishId}/toTableOrder/{orderId}")
    public void addDishToOrder(
            @PathVariable("dishId") Long dishId,
            @PathVariable("orderId") Long orderId)
            throws ElementNotFoundException {
        logger.info("Try add dish to table order");
        Dish dish = dishService.getDishById(dishId).orElseThrow(ElementNotFoundException::new);
        TableOrder order = tableOrderService.getTableOrderById(orderId).orElseThrow(ElementNotFoundException::new);
        dish.getOrders().add(order);
        order.getDishes().add(dish);
        dishService.saveDish(dish);
        tableOrderService.saveTableOrder(order);
        logger.info("Add dish " + dish + " to order " + order);
    }

    @PutMapping(value = "removeDish/{dishId}/fromTableOrder/{orderId}")
    public void removeDishFromOrder(
            @PathVariable("dishId") Long dishId,
            @PathVariable("orderId") Long orderId)
            throws ElementNotFoundException {
        Dish dish = dishService.getDishById(dishId).orElseThrow(ElementNotFoundException::new);
        TableOrder order = tableOrderService.getTableOrderById(orderId).orElseThrow(ElementNotFoundException::new);
        order.getDishes().remove(dish);
        dish.getOrders().remove(order);
        tableOrderService.saveTableOrder(order);
        dishService.saveDish(dish);
        logger.info("Remove dish " + dish + " from " + order);
    }

    @GetMapping(value = "getDishes/{id}")
    public List<Dish> getDishes(@PathVariable("id") Long id) throws ElementNotFoundException {
        return tableOrderService.getTableOrderById(id).get().getDishes();
    }
}
