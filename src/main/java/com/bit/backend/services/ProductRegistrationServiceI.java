package com.bit.backend.services;

import com.bit.backend.dtos.ProductRegistrationDto;

import java.util.List;

public interface ProductRegistrationServiceI {
    ProductRegistrationDto addProductRegistrationEntity(ProductRegistrationDto productRegistrationDto);
    List<ProductRegistrationDto> getData();
    ProductRegistrationDto updateProductRegistration(long id, ProductRegistrationDto productRegistrationDto);
    ProductRegistrationDto deleteProdRegForm(long id);
}
