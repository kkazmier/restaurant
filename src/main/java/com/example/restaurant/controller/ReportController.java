package com.example.restaurant.controller;

import com.example.restaurant.service.ReportService;
import com.example.restaurant.service.ReportServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/v1/report/")
@AllArgsConstructor
public class ReportController {
    private final Logger logger = LoggerFactory.getLogger(ReportController.class);
    private ReportServiceImpl reportService;

    @GetMapping("summaryOrdersCostFrom/{begin}/to/{end}")
    public BigDecimal calculateTotalOrderCostInGivenPeriodicTime(
            @PathVariable("begin") String begin,
            @PathVariable("end") String end){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return reportService.calculateTotalOrderCostInGivenPeriodicTime(
                LocalDateTime.parse(begin, formatter),
                LocalDateTime.parse(end, formatter)
        );
    }
}
