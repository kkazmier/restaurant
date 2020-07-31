package com.example.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Entity
@Table(name = "deliveryOrders")
public class DeliveryOrder extends BaseOrder {

}
