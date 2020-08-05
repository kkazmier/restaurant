package com.example.restaurant.service;

import com.example.restaurant.domain.Employee;
import com.example.restaurant.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTestSuite {
    @InjectMocks
    private EmployeeServiceImpl service;

    @Mock
    private EmployeeRepository repository;

    @Test
    public void testSetPIN() {
        String pin = "1234";
        Employee emp = new Employee();
        emp.setPIN(pin);
        when(repository.existsByPIN(pin)).thenReturn(true);
        when(!repository.existsByPIN(pin)).thenReturn(false);
    }
}
