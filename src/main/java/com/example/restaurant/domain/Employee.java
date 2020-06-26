package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee extends Person {
    @Column(name = "hireDate")
    private LocalDate hireDate;

    @JsonManagedReference
    @OneToMany(
            targetEntity = Role.class,
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Role> roles = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(
            targetEntity = TableOrder.class,
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<TableOrder> orders = new ArrayList<>();
}
