package com.example.restaurant.service;

import com.example.restaurant.domain.Employee;
import com.example.restaurant.domain.Role;
import com.example.restaurant.exception.ElementNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Optional<Employee> getEmployee(Long id) throws Exception;

    Optional<Employee> getEmployeeByPIN(String pin);

    Boolean isExistEmployeeByGivenPIN(String pin);

    String getPIN(Long id);

    Boolean setPIN(Long id, String pin);

    void changePIN(Long id, String pin) throws ElementNotFoundException;

    void setRole(Role role, Long id);

    Role getRole(Long id);
}
