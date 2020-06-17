package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Role extends NamedEntity {
    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "id",
            nullable = false)
    private Employee employee;
}
