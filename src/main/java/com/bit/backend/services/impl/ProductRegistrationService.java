package com.bit.backend.services.impl;


import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.dtos.ProductRegistrationDto;
import com.bit.backend.entities.CustomerRegistrationEntity;
import com.bit.backend.entities.ProductRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.CustomerRegistrationMapper;
import com.bit.backend.mappers.ProductRegistrationMapper;
import com.bit.backend.repositories.CustomerRegistrationRepository;
import com.bit.backend.repositories.ProductRegistrationRepository;
import com.bit.backend.services.ProductRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductRegistrationService implements ProductRegistrationServiceI{

    private final ProductRegistrationRepository productRegistrationRepository;
    private final ProductRegistrationMapper productRegistrationMapper;

    public ProductRegistrationService(ProductRegistrationRepository productRegistrationRepository, ProductRegistrationMapper productRegistrationMapper) {
        this.productRegistrationRepository = productRegistrationRepository;
        this.productRegistrationMapper = productRegistrationMapper;
    }

    @Override
    public ProductRegistrationDto addProductRegistrationEntity(ProductRegistrationDto productRegistrationDto) {
        try {
            System.out.println("*******************************");

            ProductRegistrationEntity productRegistrationEntity = productRegistrationMapper.toProductRegistrationEntity(productRegistrationDto);

            ProductRegistrationEntity savedItem = productRegistrationRepository.save(productRegistrationEntity);

            ProductRegistrationDto savedDto = productRegistrationMapper.toProductRegistrationDto(savedItem);

            return savedDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<ProductRegistrationDto> getData() {
        try {
            List<ProductRegistrationEntity> productRegistrationEntityList = productRegistrationRepository.findAll();
            List<ProductRegistrationDto> productRegistrationDtoList = productRegistrationMapper.toProductRegistrationDtoList(productRegistrationEntityList);
            return productRegistrationDtoList;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ProductRegistrationDto updateProductRegistration(long id, ProductRegistrationDto productRegistrationDto) {
        try {
            Optional<ProductRegistrationEntity> optionalProductRegistrationEntity = productRegistrationRepository.findById(id);

            if (!optionalProductRegistrationEntity.isPresent()) {
                throw new AppException("Product registration does not exists",HttpStatus.BAD_REQUEST);
            }

            ProductRegistrationEntity newProductRegistrationEntity = productRegistrationMapper.toProductRegistrationEntity(productRegistrationDto);
            newProductRegistrationEntity.setId(id);

            ProductRegistrationEntity productRegistrationEntity = productRegistrationRepository.save(newProductRegistrationEntity);
            ProductRegistrationDto responseProductRegistrationDto = productRegistrationMapper.toProductRegistrationDto(productRegistrationEntity);
            return responseProductRegistrationDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ProductRegistrationDto deleteProdRegForm(long id) {
        try {
            Optional<ProductRegistrationEntity> optionalProductRegistrationEntity = productRegistrationRepository.findById(id);

            if (!optionalProductRegistrationEntity.isPresent()) {
                throw new AppException("Product registration does not exists",HttpStatus.BAD_REQUEST);
            }
            productRegistrationRepository.deleteById(id);
            return productRegistrationMapper.toProductRegistrationDto(optionalProductRegistrationEntity.get());
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
