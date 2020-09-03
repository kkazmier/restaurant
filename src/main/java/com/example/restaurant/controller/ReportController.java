package com.example.restaurant.controller;

import com.example.restaurant.service.ReportService;
import com.example.restaurant.service.ReportServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/report/")
@AllArgsConstructor
public class ReportController {
    private ReportServiceImpl reportService;

    @GetMapping("summaryOrdersCostFrom/{begin}/to/{end}")
    public BigDecimal calculateTotalOrderCostInGivenPeriodicTime(
            @PathVariable("begin") LocalDateTime begin,
            @PathVariable("end") LocalDateTime end){
        return reportService.calculateTotalOrderCostInGivenPeriodicTime(begin, end);
    }
}
