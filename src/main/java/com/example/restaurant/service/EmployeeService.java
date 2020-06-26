package com.example.restaurant.service;

import com.example.restaurant.domain.Employee;
import com.example.restaurant.domain.Ingredient;

import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    Optional<Employee> getEmployee(Long id) throws Exception;
}
