package com.example.restaurant.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Getter
@Setter
public class NamedEntity extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;
}
