package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "roles")
public class Role extends NamedEntity {
    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "employeeId",
            referencedColumnName = "id",
            nullable = false)
    private Employee employee;
}
