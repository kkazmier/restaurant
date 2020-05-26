package com.example.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//@Transactional
public interface OrderRepository extends CrudRepository<Order, Long> {
    @Override
    List<Order> findAll();

    @Override
    Optional<Order> findById(Long id);

    @Override
    Order save(Order order);

    @Override
    void deleteById(Long id);
}
