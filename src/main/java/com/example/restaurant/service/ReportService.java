package com.example.restaurant.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ReportService {
    BigDecimal calculateTotalOrderCostInGivenPeriodicTime(LocalDateTime time1, LocalDateTime time2);
}
