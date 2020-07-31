package com.example.restaurant.service;

import com.example.restaurant.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Optional<Employee> getEmployee(Long id) throws Exception;
}
