package com.example.restaurant.service;

import com.example.restaurant.domain.TableOrder;
import com.example.restaurant.exception.ElementNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TableOrderService {
    Optional<TableOrder> getTableOrderById(Long id) throws ElementNotFoundException;

    List<TableOrder> getAllTableOrders();

    List<TableOrder> getOrdersByEmpId(Long id);

    TableOrder saveTableOrder(TableOrder order);

    void deleteTableOrder(Long id);

    void close(Long id);

    boolean isTableOrderExist(Long id);
}
