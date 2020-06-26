package com.example.restaurant.repository;

import com.example.restaurant.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee save(Employee employee);

    Optional<Employee> findEmployeeById(Long id);
}
