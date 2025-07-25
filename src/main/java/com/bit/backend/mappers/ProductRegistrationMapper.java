package com.bit.backend.mappers;

import com.bit.backend.dtos.ProductRegistrationDto;
import com.bit.backend.entities.ProductRegistrationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ProductRegistrationMapper {

    @Mapping(target = "colors", expression = "java(splitColors(entity.getColors()))")
    ProductRegistrationDto toProductRegistrationDto(ProductRegistrationEntity entity);

    @Mapping(target = "colors", expression = "java(joinColors(dto.getColors()))")
    ProductRegistrationEntity toProductRegistrationEntity(ProductRegistrationDto dto);

    List<ProductRegistrationDto> toProductRegistrationDtoList(List<ProductRegistrationEntity> productRegistrationEntityList);

    default List<String> splitColors(String colors) {
        return (colors == null || colors.isEmpty())
                ? List.of()
                : Arrays.asList(colors.split(","));
    }

    default String joinColors(List<String> colors) {
        return (colors == null || colors.isEmpty())
                ? ""
                : String.join(",", colors);
    }
}
