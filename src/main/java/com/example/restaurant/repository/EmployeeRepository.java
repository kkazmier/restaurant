package com.example.restaurant.repository;

import com.example.restaurant.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAll();

    Employee save(Employee employee);

    Optional<Employee> findEmployeeById(Long id);

    Boolean existsByPIN(String pin);

    Optional<Employee> findEmployeeByPIN(String pin);
}
