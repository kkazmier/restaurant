package com.example.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
    private String Town;

    @Column
    private String Street;

    @Column
    private String buildingNumber;

    @Column
    private String flatNumber;

    @Column
    private String zipCode;
}
