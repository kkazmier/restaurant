package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Getter
@Setter
public class BaseOrder extends NamedEntity {
    @Column(name = "createdTime")
    private LocalDateTime createdTime;

    @Column(name = "closedTime")
    private LocalDateTime closedTime;

    @Column
    private String status;

    @Column(name = "totalCost")
    private BigDecimal totalCost;
}
