package com.bit.backend.services.impl;


import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.entities.BillingFormEntity;
import com.bit.backend.entities.OrderDetailsEntity;
import com.bit.backend.entities.OrderSummaryEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.BillingFormMapper;
import com.bit.backend.mappers.OrderDetailsMapper;
import com.bit.backend.repositories.BillingFormRepository;
import com.bit.backend.repositories.OrderDetailsRepository;
import com.bit.backend.repositories.OrderSummaryRepository;
import com.bit.backend.services.OrderDetailsServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService implements OrderDetailsServiceI {

    private final OrderDetailsRepository orderDetailsRepository;
    private final OrderSummaryRepository orderSummaryRepository;
    private  final BillingFormRepository billingFormRepository;
    private final OrderDetailsMapper orderDetailsMapper;


    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository,
                               OrderDetailsMapper orderDetailsMapper,
                               OrderSummaryRepository orderSummaryRepository,
                               BillingFormRepository billingFormRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.orderDetailsMapper = orderDetailsMapper;
        this.orderSummaryRepository = orderSummaryRepository;
        this.billingFormRepository = billingFormRepository;
    }

    @Override
    public OrderDetailsDto addOrderDetailsEntity(OrderDetailsDto orderDetailsDto) {
        try {
            System.out.println("*******************************");
            OrderDetailsEntity orderDetailsEntity = orderDetailsMapper.toOrderDetailsEntity(orderDetailsDto);
            List<OrderSummaryEntity> orderSummaryEntityList = orderDetailsMapper.toOrderSummaryEntityList(orderDetailsDto.getItems());
            BillingFormEntity billingFormEntity = orderDetailsMapper.toBillingFormEntity(orderDetailsDto);

            OrderDetailsEntity savedOrderDetailsEntity = orderDetailsRepository.save(orderDetailsEntity);

            for(OrderSummaryEntity orderSummaryEntity: orderSummaryEntityList) {
                orderSummaryEntity.setOrderId(savedOrderDetailsEntity.getId());
            }

            billingFormEntity.setOrderId(savedOrderDetailsEntity.getId());

            List<OrderSummaryEntity> savedOrderSummaryEntityList = orderSummaryRepository.saveAll(orderSummaryEntityList);
            BillingFormEntity savedBillingFormEntity = billingFormRepository.save(billingFormEntity);

            OrderDetailsDto savedOrderDetailsDto = this.orderDetailsMapper.toOrderDetailsDto(savedOrderDetailsEntity);
            savedOrderDetailsDto.setBillingFormDto(orderDetailsMapper.toBillingFormDto(savedBillingFormEntity));
            savedOrderDetailsDto.setItems(orderDetailsMapper.toOrderItemDtoList(savedOrderSummaryEntityList));
            return savedOrderDetailsDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @Override
//    public OrderDetailsDto addOrderDetailsEntity(OrderDetailsDto orderDetailsDto) {
//        return null;
//    }

    @Override
    public List<OrderDetailsDto> getData() {
//        try {
//            List<BillingFormEntity> billingFormEntityList = orderDetailsRepository.findAll();
//            List<OrderDetailsDto> orderDetailsDtoList = billingFormMapper.toBillingFormDtoList(billingFormEntityList);
//            return orderDetailsDtoList;
//        }
//        catch (Exception e) {
//            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        return null;
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
