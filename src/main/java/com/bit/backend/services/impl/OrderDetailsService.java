package com.bit.backend.services.impl;


import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.entities.BillingFormEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.BillingFormMapper;
import com.bit.backend.repositories.OrderDetailsRepository;
import com.bit.backend.services.OrderDetailsServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService implements OrderDetailsServiceI {

    private final OrderDetailsRepository orderDetailsRepository;


    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;

    }

    @Override
    public OrderDetailsDto addOrderDetailsEntity(OrderDetailsDto orderDetailsDto) {
        try {
            System.out.println("*******************************");

            BillingFormEntity billingFormEntity = new BillingFormEntity();
            billingFormEntity.setName(orderDetailsDto.getName());
            billingFormEntity.setEmail(orderDetailsDto.getEmail());
            billingFormEntity.setContactNumber(orderDetailsDto.getContactNumber());
            billingFormEntity.setAddress(orderDetailsDto.getAddress());
            billingFormEntity.setOrderId(orderDetailsDto.getOrderId());
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public OrderDetailsDto addOrderDetailsEntity(OrderDetailsDto orderDetailsDto) {
        return null;
    }

    @Override
    public List<OrderDetailsDto> getData() {
        try {
            List<BillingFormEntity> billingFormEntityList = orderDetailsRepository.findAll();
            List<OrderDetailsDto> orderDetailsDtoList = billingFormMapper.toBillingFormDtoList(billingFormEntityList);
            return orderDetailsDtoList;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public OrderDetailsDto updateOrderDetails(long id, OrderDetailsDto orderDetailsDto) {
        return null;
    }

    @Override
    public OrderDetailsDto deleteOrderDetails(long id) {
        return null;
    }

}
