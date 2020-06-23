package com.example.restaurant.controller;

import com.example.restaurant.domain.Employee;
import com.example.restaurant.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/v1/employee/")
@AllArgsConstructor
public class EmployeeController {
    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createEmployee(@RequestBody Employee employee){
        logger.info("Create new employee: " + employee.getFirstName() + " " + employee.getLastName());
        employeeService.saveEmployee(employee);
    }
}
