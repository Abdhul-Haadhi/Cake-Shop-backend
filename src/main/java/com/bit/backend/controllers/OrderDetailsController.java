package com.bit.backend.controllers;


import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.OrderDetailsServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class OrderDetailsController {
    private  final OrderDetailsServiceI orderDetailsServiceI;

    public OrderDetailsController(OrderDetailsServiceI orderDetailsServiceI) {
        this.orderDetailsServiceI = orderDetailsServiceI;
    }

    @PostMapping("/checkout-page")
    public ResponseEntity<OrderDetailsDto> addForm(@RequestBody OrderDetailsDto orderDetailsDto) {

        try {
            OrderDetailsDto orderDetailsDtoResponse = orderDetailsServiceI.addBillingFormEntity(orderDetailsDto);
            return ResponseEntity.created(URI.create("/checkout-page"+ orderDetailsDtoResponse.getId())).body(orderDetailsDtoResponse);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/checkout-page")
    public ResponseEntity<List<OrderDetailsDto>> getData() {

        try {
            List<OrderDetailsDto> orderDetailsDtoList = orderDetailsServiceI.getData();
            return ResponseEntity.ok(orderDetailsDtoList);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
