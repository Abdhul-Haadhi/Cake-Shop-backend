package com.bit.backend.controllers;


import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.dtos.SupplierRegistrationDto;
import com.bit.backend.entities.SupplierRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.EmployeeRegistrationServiceI;
import com.bit.backend.services.SupplierRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class SupplierRegistrationController {
    private final SupplierRegistrationServiceI supplierRegistrationServiceI;

    public SupplierRegistrationController(SupplierRegistrationServiceI supplierRegistrationServiceI) {
        this.supplierRegistrationServiceI = supplierRegistrationServiceI;
    }

    @PostMapping("/supplier-registration")
    public ResponseEntity<SupplierRegistrationDto> addForm(@RequestBody SupplierRegistrationDto supplierRegistrationDto) {

        try {
            SupplierRegistrationDto supplierRegistrationDtoResponse = supplierRegistrationServiceI.addSupplierRegistrationEntity(supplierRegistrationDto);
            return ResponseEntity.created(URI.create("/supplier-registration"+supplierRegistrationDtoResponse.getId())).body(supplierRegistrationDtoResponse);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/supplier-registration")

    public ResponseEntity<List<SupplierRegistrationDto>> getData(){

        try {
            List<SupplierRegistrationDto> supplierRegistrationDtoList = supplierRegistrationServiceI.getData();
            return ResponseEntity.ok(supplierRegistrationDtoList);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/supplier-registration/{id}")
    public ResponseEntity<SupplierRegistrationDto> updateSuppRegForm(@PathVariable Long id, @RequestBody SupplierRegistrationDto supplierRegistrationDto) {

        try {
            SupplierRegistrationDto responseSupplierRegistrationDto = supplierRegistrationServiceI.updateSupplierRegistration(id,supplierRegistrationDto);
            return ResponseEntity.ok(responseSupplierRegistrationDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/supplier-registration/{id}")
    public  ResponseEntity<SupplierRegistrationDto> deleteSuppRegForm(@PathVariable Long id) {

        try {
            SupplierRegistrationDto supplierRegistrationDto = supplierRegistrationServiceI.deleteSuppRegForm(id);
            return ResponseEntity.ok(supplierRegistrationDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
