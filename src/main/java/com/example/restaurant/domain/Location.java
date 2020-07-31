package com.example.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "locations")
public class Location extends BaseEntity {
    @Column
    private String town;

    @Column
    private String street;

    @Column(name = "buildingNumber")
    private String buildingNumber;

    @Column(name = "flatNumber")
    private String flatNumber;

    @Column(name = "zipCode")
    private String zipCode;
}
