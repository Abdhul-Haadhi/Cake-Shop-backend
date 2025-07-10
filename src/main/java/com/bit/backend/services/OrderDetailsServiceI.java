package com.bit.backend.services;

import com.bit.backend.dtos.OrderDetailsDto;

import java.util.List;

public interface OrderDetailsServiceI {
    OrderDetailsDto addOrderDetailsEntity(OrderDetailsDto orderDetailsDto);
    List<OrderDetailsDto> getData();
    OrderDetailsDto updateOrderDetails(long id, OrderDetailsDto orderDetailsDto);
    OrderDetailsDto deleteOrderDetails(long id);
}
