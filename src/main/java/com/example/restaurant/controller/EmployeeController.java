package com.example.restaurant.controller;

import com.example.restaurant.domain.Employee;
import com.example.restaurant.domain.TableOrder;
import com.example.restaurant.service.EmployeeService;
import com.example.restaurant.service.TableOrderService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/employee/")
@AllArgsConstructor
public class EmployeeController {
    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;
    private final TableOrderService tableOrderService;

    @GetMapping(value = "all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createEmployee(@RequestBody Employee employee){
        logger.info("Create new employee: " + employee.getFirstName() + " " + employee.getLastName());
        employeeService.saveEmployee(employee);
    }

    @PutMapping(value = "createTableOrder/{empId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTableOrder(@RequestBody TableOrder order, @PathVariable("empId") Long empId) throws Exception {
        logger.info("Try add new table order to employee");
        order.setCreatedTime(LocalDateTime.now());
        order.setStatus("Otwarte");
        order.setTotalCost(0.00);
        Employee emp = employeeService.getEmployee(empId).orElseThrow(Exception::new);
        emp.getOrders().add(order);
        order.setEmployee(emp);
        employeeService.saveEmployee(emp);
        tableOrderService.saveTableOrder(order);
    }

    @PutMapping(value = "deleteTableOrder/{orderId}/fromEmployee/{empId}")
    public void deleteTableOrder(
            @PathVariable("orderId") Long orderId,
            @PathVariable("empId") Long empId)
            throws Exception{
        Employee emp = employeeService.getEmployee(empId).orElseThrow(Exception::new);
        TableOrder order = tableOrderService.getTableOrderById(orderId).orElseThrow(Exception::new);
        emp.getOrders().remove(order);
        tableOrderService.deleteTableOrder(orderId);
    }
}
