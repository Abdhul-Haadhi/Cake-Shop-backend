package com.bit.backend.services.impl;

import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.entities.CustomerRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.CustomerRegistrationMapper;
import com.bit.backend.repositories.CustomerRegistrationRepository;
import com.bit.backend.services.CustomerRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerRegistrationService implements CustomerRegistrationServiceI {

    private final CustomerRegistrationRepository customerRegistrationRepository;
    private final CustomerRegistrationMapper customerRegistrationMapper;

    public CustomerRegistrationService(CustomerRegistrationRepository customerRegistrationRepository, CustomerRegistrationMapper customerRegistrationMapper) {
        this.customerRegistrationRepository = customerRegistrationRepository;
        this.customerRegistrationMapper = customerRegistrationMapper;
    }


    @Override
    public CustomerRegistrationDto addCustomerRegistrationEntity(CustomerRegistrationDto customerRegistrationDto) {

        try {
            System.out.println("*******************************");

            CustomerRegistrationEntity customerRegistrationEntity = customerRegistrationMapper.toCustomerRegistrationEntity(customerRegistrationDto);

            CustomerRegistrationEntity savedItem = customerRegistrationRepository.save(customerRegistrationEntity);

            CustomerRegistrationDto savedDto = customerRegistrationMapper.toCustomerRegistrationDto(savedItem);

            return savedDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<CustomerRegistrationDto> getData() {

        try {
            List<CustomerRegistrationEntity> customerRegistrationEntityList = customerRegistrationRepository.findAll();
            List<CustomerRegistrationDto> customerRegistrationDtoList = customerRegistrationMapper.toCustomerRegistrationDtoList(customerRegistrationEntityList);
            return customerRegistrationDtoList;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CustomerRegistrationDto updateCustomerRegistration(long id, CustomerRegistrationDto customerRegistrationDto) {

        try {
            Optional<CustomerRegistrationEntity> optionalCustomerRegistrationEntity = customerRegistrationRepository.findById(id);

            if (!optionalCustomerRegistrationEntity.isPresent()) {
                throw new AppException("Customer registration does not exists",HttpStatus.BAD_REQUEST);
            }

            CustomerRegistrationEntity newCustomerRegistrationEntity = customerRegistrationMapper.toCustomerRegistrationEntity(customerRegistrationDto);
            newCustomerRegistrationEntity.setId(id);

            CustomerRegistrationEntity customerRegistrationEntity = customerRegistrationRepository.save(newCustomerRegistrationEntity);
            CustomerRegistrationDto responseCustomerRegistrationDto = customerRegistrationMapper.toCustomerRegistrationDto(customerRegistrationEntity);
            return responseCustomerRegistrationDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CustomerRegistrationDto deleteCustRegForm(long id) {
        try {
            Optional<CustomerRegistrationEntity> optionalCustomerRegistrationEntity = customerRegistrationRepository.findById(id);

            if (!optionalCustomerRegistrationEntity.isPresent()) {
                throw new AppException("Customer registration does not exists",HttpStatus.BAD_REQUEST);
            }
            customerRegistrationRepository.deleteById(id);
            return customerRegistrationMapper.toCustomerRegistrationDto(optionalCustomerRegistrationEntity.get());
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
