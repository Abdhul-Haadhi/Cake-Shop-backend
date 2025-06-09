package com.bit.backend.services;

import com.bit.backend.dtos.CustomerRegistrationDto;

import java.util.List;

public interface CustomerRegistrationServiceI {
    CustomerRegistrationDto addCustomerRegistrationEntity(CustomerRegistrationDto customerRegistrationDto);
    List<CustomerRegistrationDto> getData();
    CustomerRegistrationDto updateCustomerRegistration(long id, CustomerRegistrationDto customerRegistrationDto);
    CustomerRegistrationDto deleteCustRegForm(long id);
}
