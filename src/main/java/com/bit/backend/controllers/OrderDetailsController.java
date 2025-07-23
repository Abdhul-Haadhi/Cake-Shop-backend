package com.bit.backend.controllers;



import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.dtos.OrderListDto;
import com.bit.backend.entities.OrderDetailsEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.OrderDetailsServiceI;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
public class OrderDetailsController {
    private  final OrderDetailsServiceI orderDetailsServiceI;

    public OrderDetailsController(OrderDetailsServiceI orderDetailsServiceI) {
        this.orderDetailsServiceI = orderDetailsServiceI;
    }



//original one----------------
    @PostMapping(value = "/checkout-page", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<OrderDetailsDto> addForm(@RequestPart("orderDetailsForm") OrderDetailsDto orderDetailsDto, @RequestPart("receipt")MultipartFile file) {

        try {
            OrderDetailsDto orderDetailsDtoResponse = orderDetailsServiceI.addOrderDetailsEntity(orderDetailsDto, file);
            return ResponseEntity.created(URI.create("/checkout-page"+ orderDetailsDtoResponse.getId())).body(orderDetailsDtoResponse);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



//    @PostMapping(value = "/checkout-page", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<OrderDetailsDto> addForm(@RequestPart("orderDetailsForm") OrderDetailsDto orderDetailsDto, @RequestPart("receipt")MultipartFile file) {
//
//        try {
//            OrderDetailsDto orderDetailsDtoResponse = orderDetailsServiceI.addOrderDetailsEntity(orderDetailsDto);
//            return ResponseEntity.created(URI.create("/checkout-page"+ orderDetailsDtoResponse.getId())).body(orderDetailsDtoResponse);
//        }
//        catch (Exception e) {
//            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/checkout-page")
    public ResponseEntity<List<OrderListDto>> getItemListData() {

        try {
            List<OrderListDto> orderListDtoList = orderDetailsServiceI.getItemListData();
            return ResponseEntity.ok(orderListDtoList);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/order-list/filter")
    public ResponseEntity<List<OrderListDto>> filterByDate(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        List<OrderListDto> dtos = orderDetailsServiceI.filterByDateRange(startDate, endDate);
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/order-list/{orderId}/status")
    public ResponseEntity<OrderListDto> updateOrderStatus(@PathVariable Integer orderId, @RequestBody OrderListDto orderListDto) {

        try {
            OrderListDto updatedDto = orderDetailsServiceI.updateOrderStatus(orderId, orderListDto.getStatus());
            return ResponseEntity.ok(updatedDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
