package com.example.restaurant.service;

import com.example.restaurant.domain.TableOrder;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.repository.TableOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional
@AllArgsConstructor
public class TableOrderServiceImpl implements TableOrderService {
    private final TableOrderRepository tableOrderRepository;

    @Override
    public Optional<TableOrder> getTableOrderById(Long id) throws ElementNotFoundException {
        return Optional.of(tableOrderRepository.findById(id)).orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public List<TableOrder> getAllTableOrders() {
        return tableOrderRepository.findAll();
    }

    @Override
    public TableOrder saveTableOrder(TableOrder order) {
        return tableOrderRepository.save(order);
    }

    @Override
    public void deleteTableOrder(Long id) {
        tableOrderRepository.deleteTableOrderById(id);
    }

    @Override
    public boolean isTableOrderExist(Long id) {
        return tableOrderRepository.existsTableOrderById(id);
    }

    @Override
    public void calculateTotalCost(Long id) throws ElementNotFoundException {
        TableOrder order = tableOrderRepository.findById(id).orElseThrow(ElementNotFoundException::new);
        AtomicReference<Double> totalCost = new AtomicReference<>(0.0);
        order.getDishes()
                .stream().forEach(d -> totalCost.updateAndGet(v -> v + d.getPrice()));
    }
}
