package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Getter
public class BaseOrder extends NamedEntity {
    @Column(name = "createdTime")
    private LocalDateTime createdTime;

    @Column(name = "closedTime")
    private LocalDateTime closedTime;

    @Column
    private String status;

    @Column(name = "totalCost")
    private Double totalCost;
}
