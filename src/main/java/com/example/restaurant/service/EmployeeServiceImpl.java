package com.example.restaurant.service;

import com.example.restaurant.domain.Employee;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import security.AuthorisationDataStorage;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployee(Long id) throws Exception {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public String getPIN(Long id) {
        return employeeRepository
                .findEmployeeById(id)
                .get()
                .getPIN();
    }

    @Override
    public void setPIN(Long id, String pin) {
        employeeRepository
                .findEmployeeById(id)
                .get()
                .setPIN(pin);
    }

    @Override
    public void changePIN(Long id, String pin)  {
        employeeRepository
                .findEmployeeById(id)
                .get()
                .setPIN(pin);
    }
}
