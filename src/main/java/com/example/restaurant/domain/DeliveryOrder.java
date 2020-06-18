package com.example.restaurant.domain;

import com.example.restaurant.domain.BaseOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Entity
@Table(name = "delivery_orders")
public class DeliveryOrder extends BaseOrder {

}
