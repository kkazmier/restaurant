package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee extends Person {
    @Column(name = "roles")
    private Role role;

    @Column(name = "hireDate")
    private LocalDate hireDate;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String PIN;

    @JsonManagedReference
    @OneToMany(
            targetEntity = TableOrder.class,
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<TableOrder> orders = new ArrayList<>();
}
