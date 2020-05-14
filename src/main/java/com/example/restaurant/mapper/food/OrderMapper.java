package com.example.restaurant.mapper.food;

import com.example.restaurant.domain.Order;
import com.example.restaurant.domain.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    public Order mapToOrder(OrderDto orderDto){
        return new Order(
                orderDto.getOrderId(),
                orderDto.getStatus(),
                orderDto.getCreateTime(),
                orderDto.getCloseTime(),
                orderDto.getDescription(),
                orderDto.isTakeAway(),
                orderDto.getDishes()
        );
    }

    public OrderDto mapToOrderDto(Order order){
        return new OrderDto(
                order.getOrderId(),
                order.getStatus(),
                order.getCreateTime(),
                order.getCloseTime(),
                order.getDescription(),
                order.isTakeAway(),
                order.getDishes()
        );
    }

    public List<OrderDto> getMapToOrderDtosList(List<Order> orders){
        return orders.stream()
                .map(o -> new OrderDto(
                        o.getOrderId(),
                        o.getStatus(),
                        o.getCreateTime(),
                        o.getCloseTime(),
                        o.getDescription(),
                        o.isTakeAway(),
                        o.getDishes()))
                .collect(Collectors.toList());
    }
}
