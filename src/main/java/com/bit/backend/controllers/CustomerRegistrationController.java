package com.bit.backend.controllers;


import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.dtos.SignUpDto;
import com.bit.backend.dtos.UserDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.CustomerRegistrationServiceI;
import com.bit.backend.services.UserServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class CustomerRegistrationController {
    private  final CustomerRegistrationServiceI customerRegistrationServiceI;
    private final UserServiceI userServiceI;

    public CustomerRegistrationController(CustomerRegistrationServiceI customerRegistrationServiceI, UserServiceI userServiceI) {
        this.customerRegistrationServiceI = customerRegistrationServiceI;
        this.userServiceI = userServiceI;
    }

    @PostMapping("/customer-registration")

    public ResponseEntity<CustomerRegistrationDto> addForm(@RequestBody CustomerRegistrationDto customerRegistrationDto) {

        try {
            CustomerRegistrationDto customerRegistrationDtoResponse = customerRegistrationServiceI.addCustomerRegistrationEntity(customerRegistrationDto);
            return ResponseEntity.created(URI.create("/customer-registration"+customerRegistrationDtoResponse.getId())).body(customerRegistrationDtoResponse);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/customer-registration")
    public ResponseEntity<List<CustomerRegistrationDto>> getData() {

        try {
            List<CustomerRegistrationDto> customerRegistrationDtoList = customerRegistrationServiceI.getData();
            return ResponseEntity.ok(customerRegistrationDtoList);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/customer-registration/{id}")

    public ResponseEntity<CustomerRegistrationDto> updateCustRegForm(@PathVariable Long id, @RequestBody CustomerRegistrationDto customerRegistrationDto) {

        try {
            CustomerRegistrationDto responseCustomerRegistrationDto = customerRegistrationServiceI.updateCustomerRegistration(id,customerRegistrationDto);
            return ResponseEntity.ok(responseCustomerRegistrationDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/customer-registration/{id}")
    public ResponseEntity<CustomerRegistrationDto> deleteCustRegForm(@PathVariable Long id) {

        try {
            CustomerRegistrationDto customerRegistrationDto = customerRegistrationServiceI.deleteCustRegForm(id);
            return ResponseEntity.ok(customerRegistrationDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create-customer-login")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto) throws Exception {
        UserDto user = userServiceI.register(signUpDto);
        return ResponseEntity.created(URI.create("/create-employee-login/" + user.getId())).body(user);
    }

    @PutMapping("/update-customer-login-details/{id}")
    public ResponseEntity<UserDto> updateLoginDetails(@PathVariable Long id, @RequestBody SignUpDto signUpDto) throws Exception {
        UserDto user = userServiceI.updateLoginDetails(id, signUpDto);
        return ResponseEntity.created(URI.create("/create-customer-login/" + user.getId())).body(user);
    }
}
