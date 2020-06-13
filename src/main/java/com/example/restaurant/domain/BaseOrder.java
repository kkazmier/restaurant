package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public class BaseOrder extends NamedEntity {
    @Column
    private LocalDateTime createdTime;

    @Column
    private LocalDateTime closedTime;

    @Column
    private String status;
}
