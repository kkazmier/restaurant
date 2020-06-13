package com.example.restaurant.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Employee extends BaseEntity{
    @Column
    private String firstName;

    @Column
    private String lastName;
}
