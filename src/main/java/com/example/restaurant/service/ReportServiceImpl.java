package com.example.restaurant.service;

import com.example.restaurant.repository.TableOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
@Transactional
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final TableOrderRepository tableOrderRepository;

    @Override
    public BigDecimal calculateTotalOrderCostInGivenPeriodicTime(LocalDateTime time1, LocalDateTime time2) {
        BigDecimal result = BigDecimal.ZERO;
        LocalDateTime[] tt = {time1, time2};
        Arrays.sort(tt);
        tableOrderRepository
                .findAll()
                .stream()
                .forEach(o -> {
                    if(o.getClosedTime().isAfter(tt[0]) && o.getClosedTime().isBefore(tt[1])){
                        result.add(o.getTotalCost());
                    }
                });
        return result;
    }
}
