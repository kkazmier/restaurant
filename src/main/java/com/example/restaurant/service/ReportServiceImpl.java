package com.example.restaurant.service;

import com.example.restaurant.repository.TableOrderRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
@Transactional
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);
    private final TableOrderRepository tableOrderRepository;

    @Override
    public BigDecimal calculateTotalOrderCostInGivenPeriodicTime(LocalDateTime time1, LocalDateTime time2) {
        BigDecimal result;
        LocalDateTime[] tt = {time1, time2};
        Arrays.sort(tt);
        result = tableOrderRepository
                .findAll()
                .stream()
                .filter(o -> o.getClosedTime() != null)
                .filter(o -> o.getClosedTime().isAfter(tt[0]) && o.getClosedTime().isBefore(tt[1]))
                .map(o -> o.getTotalCost())
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        return result;
    }
}
