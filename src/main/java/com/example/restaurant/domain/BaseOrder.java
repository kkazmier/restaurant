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
    @Column
    private LocalDateTime createdTime;

    @Column
    private LocalDateTime closedTime;

    @Column
    private String status;

    @Column
    private Double totalCost;
}
