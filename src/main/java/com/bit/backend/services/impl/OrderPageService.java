package com.bit.backend.services.impl;


import com.bit.backend.dtos.OrderPageDto;
import com.bit.backend.entities.OrderPageEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.OrderPageMapper;
import com.bit.backend.repositories.OrderPageRepository;
import com.bit.backend.services.OrderPageServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderPageService implements OrderPageServiceI {

    private final OrderPageRepository orderPageRepository;
    private final OrderPageMapper orderPageMapper;

    public OrderPageService(OrderPageRepository orderPageRepository, OrderPageMapper orderPageMapper) {
        this.orderPageRepository = orderPageRepository;
        this.orderPageMapper = orderPageMapper;
    }


    @Override
    public OrderPageDto addOrderPageEntity(OrderPageDto orderPageDto) {
        try {
            System.out.println("*******************************");

            OrderPageEntity orderPageEntity = orderPageMapper.toOrderPageEntity(orderPageDto);

            OrderPageEntity savedItem = orderPageRepository.save(orderPageEntity);
            OrderPageDto savedDto = orderPageMapper.toOrderPageDto(savedItem);

            return savedDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<OrderPageDto> getData() {
        try {
            List<OrderPageEntity> orderPageEntityList = orderPageRepository.findAll();
            List<OrderPageDto> orderPageDtosList = orderPageMapper.toOrderPageDtoList(orderPageEntityList);
            return orderPageDtosList;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public OrderPageDto updateOrderPage(long id, OrderPageDto orderPageDto) {
        try {
            Optional<OrderPageEntity> optionalOrderPageEntity = orderPageRepository.findById(id);

            if (!optionalOrderPageEntity.isPresent()) {
                throw new AppException("Order page does not Exists", HttpStatus.BAD_REQUEST);
            }

            OrderPageEntity newOrderPageEntity = orderPageMapper.toOrderPageEntity(orderPageDto);
            newOrderPageEntity.setId(id);


            OrderPageEntity orderPageEntity = orderPageRepository.save(newOrderPageEntity);
            OrderPageDto responseOrderPageDto = orderPageMapper.toOrderPageDto(orderPageEntity);
            return responseOrderPageDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public OrderPageDto deleteOrderPageForm(long id) {
        try {
            Optional<OrderPageEntity> optionalOrderPageEntity = orderPageRepository.findById(id);

            if (!optionalOrderPageEntity.isPresent()) {
                throw new AppException("Order does not exists",HttpStatus.BAD_REQUEST);
            }
            orderPageRepository.deleteById(id);
            return orderPageMapper.toOrderPageDto(optionalOrderPageEntity.get());
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
