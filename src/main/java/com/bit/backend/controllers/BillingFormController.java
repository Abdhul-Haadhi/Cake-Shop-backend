package com.bit.backend.controllers;


import com.bit.backend.dtos.BillingFormDto;
import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.BillingFormServiceI;
import com.bit.backend.services.CustomerRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class BillingFormController {
    private  final BillingFormServiceI billingFormServiceI;

    public BillingFormController(BillingFormServiceI billingFormServiceI) {
        this.billingFormServiceI = billingFormServiceI;
    }

    @PostMapping("/checkout-page")
    public ResponseEntity<BillingFormDto> addForm(@RequestBody BillingFormDto billingFormDto) {

        try {
            BillingFormDto billingFormDtoResponse = billingFormServiceI.addBillingFormEntity(billingFormDto);
            return ResponseEntity.created(URI.create("/checkout-page"+billingFormDtoResponse.getId())).body(billingFormDtoResponse);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/checkout-page")
    public ResponseEntity<List<BillingFormDto>> getData() {

        try {
            List<BillingFormDto> billingFormDtoList = billingFormServiceI.getData();
            return ResponseEntity.ok(billingFormDtoList);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
