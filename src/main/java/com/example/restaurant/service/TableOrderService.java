package com.example.restaurant.service;

import com.example.restaurant.domain.TableOrder;
import com.example.restaurant.exception.ElementNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TableOrderService {
    Optional<TableOrder> getTableOrderById(Long id) throws ElementNotFoundException;

    List<TableOrder> getAllTableOrders();

    TableOrder saveTableOrder(TableOrder order);

    void deleteTableOrder(Long id);

    boolean isTableOrderExist(Long id);

    void calculateTotalCost(Long id) throws ElementNotFoundException;
}
