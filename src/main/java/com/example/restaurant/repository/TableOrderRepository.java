package com.example.restaurant.repository;

import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.TableOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface TableOrderRepository extends CrudRepository<TableOrder, Long> {
    List<TableOrder> findAll();

    List<TableOrder> getTableOrdersByEmployeeId(Long id);

    Optional<TableOrder> findById(Long id);

    TableOrder save(TableOrder tableOrder);

    void deleteTableOrderById(Long id);

    boolean existsTableOrderById(Long id);
}
