package com.example.restaurant.controller;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Employee;
import com.example.restaurant.domain.TableOrder;
import com.example.restaurant.service.DishService;
import com.example.restaurant.service.EmployeeService;
import com.example.restaurant.service.TableOrderService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/v1/tableOrder/")
@AllArgsConstructor
public class TableOrderController {
    private final Logger logger = LoggerFactory.getLogger(TableOrderController.class);

    private TableOrderService tableOrderService;
    private DishService dishService;

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTableOrder(@RequestBody TableOrder tableOrder) throws URISyntaxException, Exception {
        logger.info("Try to create new table order");
        if(tableOrderService.isTableOrderExist(tableOrder.getId())){
            return ResponseEntity.badRequest().body("Order with given id already exist.");
        }
        TableOrder result = tableOrderService.saveTableOrder(tableOrder);
        logger.info("Create new table order (id = " + result.getId() + ")");
        return ResponseEntity.created(new URI("/v1/tableOrder/create")).body(result);
    }

    @RequestMapping(value = "addDish/{dishId}/toTableOrder/{orderId}")
    public void addDishToOrder(@RequestParam("dishId") Long dishId, @RequestParam("orderId") Long orderId) throws Exception {
        logger.info("Try add dish to table order");
        Dish dish = dishService.getDishById(dishId).orElseThrow(Exception::new);
        TableOrder order = tableOrderService.getTableOrderById(orderId).orElseThrow(Exception::new);
        if(order.getId() != 0){
            if (dish.getId() != 0){

            } else {
                logger.info("Dish with given id doesn't exist!");
            }
        } else {
            logger.info("Order with given id doesn't exist!");
        }
    }
}
