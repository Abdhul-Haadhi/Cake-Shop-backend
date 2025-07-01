package com.bit.backend.mappers;


import com.bit.backend.dtos.ProductRegistrationDto;
import com.bit.backend.entities.ProductRegistrationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true))
public interface ProductRegistrationMapper {
    ProductRegistrationDto toProductRegistrationDto(ProductRegistrationEntity productRegistrationEntity);
    ProductRegistrationEntity toProductRegistrationEntity(ProductRegistrationDto productRegistrationDto);

    List<ProductRegistrationDto> toProductRegistrationDtoList(List<ProductRegistrationEntity> productRegistrationEntityList);
}
