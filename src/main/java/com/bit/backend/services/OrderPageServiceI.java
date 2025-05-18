package com.bit.backend.services;

import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.dtos.OrderPageDto;

import java.util.List;

public interface OrderPageServiceI {
    OrderPageDto addOrderPageEntity(OrderPageDto orderPageDto);
    List<OrderPageDto> getData();
    OrderPageDto updateOrderPage(long id,OrderPageDto orderPageDto);
    OrderPageDto deleteOrderPageForm(long id);
}
