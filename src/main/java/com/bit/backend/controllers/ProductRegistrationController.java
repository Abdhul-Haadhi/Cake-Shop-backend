package com.bit.backend.controllers;


import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.dtos.ProductRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.ProductRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ProductRegistrationController {
    private final ProductRegistrationServiceI productRegistrationServiceI;

    public ProductRegistrationController(ProductRegistrationServiceI productRegistrationServiceI) {
        this.productRegistrationServiceI = productRegistrationServiceI;
    }

    @PostMapping("/product-registration")

    public ResponseEntity<ProductRegistrationDto> addForm(@RequestBody ProductRegistrationDto productRegistrationDto) {

        try {
            ProductRegistrationDto productRegistrationDtoResponse = productRegistrationServiceI.addProductRegistrationEntity(productRegistrationDto);
            return ResponseEntity.created(URI.create("/product-registration"+productRegistrationDtoResponse.getId())).body(productRegistrationDtoResponse);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product-registration")
    public ResponseEntity<List<ProductRegistrationDto>> getData() {

        try {
            List<ProductRegistrationDto> productRegistrationDtoList = productRegistrationServiceI.getData();
            return ResponseEntity.ok(productRegistrationDtoList);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product-registration/{id}")

    public ResponseEntity<ProductRegistrationDto> updateProdRegForm(@PathVariable Long id, @RequestBody ProductRegistrationDto productRegistrationDto) {

        try {
            ProductRegistrationDto responseProductRegistrationDto = productRegistrationServiceI.updateProductRegistration(id,productRegistrationDto);
            return ResponseEntity.ok(responseProductRegistrationDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/product-registration/{id}")
    public ResponseEntity<ProductRegistrationDto> deleteProdRegForm(@PathVariable Long id) {

        try {
            ProductRegistrationDto productRegistrationDto = productRegistrationServiceI.deleteProdRegForm(id);
            return ResponseEntity.ok(productRegistrationDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
