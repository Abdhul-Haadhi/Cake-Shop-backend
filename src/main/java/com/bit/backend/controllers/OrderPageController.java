package com.bit.backend.controllers;


import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.dtos.FeedbackAndRatingDto;
import com.bit.backend.dtos.OrderPageDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.OrderPageServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class OrderPageController {
    private final OrderPageServiceI orderPageServiceI;

    public OrderPageController(OrderPageServiceI orderPageServiceI) {
        this.orderPageServiceI = orderPageServiceI;
    }

    @PostMapping("/order-page")
    public ResponseEntity<OrderPageDto> addForm(@RequestBody OrderPageDto orderPageDto) {

        try {
            OrderPageDto orderPageDtoResponse = orderPageServiceI.addOrderPageEntity(orderPageDto);
            return ResponseEntity.created(URI.create("/order-page"+orderPageDtoResponse.getId())).body(orderPageDtoResponse);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/order-page")

    public ResponseEntity<List<OrderPageDto>> getData(){

        try {
            List<OrderPageDto> orderPageDtoList = orderPageServiceI.getData();
            return ResponseEntity.ok(orderPageDtoList);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/order-page/{id}")

    public ResponseEntity<OrderPageDto> updateOrderPageForm(@PathVariable Long id, @RequestBody OrderPageDto orderPageDto) {

        try {
            OrderPageDto responseOrderPageDto = orderPageServiceI.updateOrderPage(id,orderPageDto);
            return ResponseEntity.ok(responseOrderPageDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/order-page/{id}")
    public ResponseEntity<OrderPageDto> deleteOrderPageForm(@PathVariable Long id) {

        try {
            OrderPageDto orderPageDto = orderPageServiceI.deleteOrderPageForm(id);
            return ResponseEntity.ok(orderPageDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
