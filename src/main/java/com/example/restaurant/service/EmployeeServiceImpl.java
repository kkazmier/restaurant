package com.example.restaurant.service;

import com.example.restaurant.domain.Employee;
import com.example.restaurant.domain.Role;
import com.example.restaurant.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import security.AuthorisationDataStorage;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
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
    public Optional<Employee> getEmployeeByPIN(String pin) {
        return employeeRepository.findEmployeeByPIN(pin);
    }

    @Override
    public Boolean isExistEmployeeByGivenPIN(String pin) {
        return employeeRepository.existsByPIN(pin);
    }

    @Override
    public String getPIN(Long id) {
        return employeeRepository
                .findEmployeeById(id)
                .get()
                .getPIN();
    }

    @Override
    public Boolean setPIN(Long id, String pin) {
        if(employeeRepository.existsByPIN(pin)){
            logger.info("Given PIN already exist!");
            return false;
        } else {
            employeeRepository.findEmployeeById(id).get().setPIN(pin);
            logger.info("PIN have been changed to: " + pin);
            return true;
        }
    }

    @Override
    public void changePIN(Long id, String pin)  {
        employeeRepository
                .findEmployeeById(id)
                .get()
                .setPIN(pin);
    }

    @Override
    public void setRole(Role role, Long id) {
        employeeRepository
                .findEmployeeById(id)
                .get()
                .setRole(role);
    }

    @Override
    public Role getRole(Long id) {
        return employeeRepository
                .findEmployeeById(id)
                .get()
                .getRole();
    }
}
