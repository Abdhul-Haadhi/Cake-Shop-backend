package com.bit.backend.mappers;


import com.bit.backend.dtos.GrnDto;
import com.bit.backend.entities.GrnEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface GrnMapper {
    GrnEntity toGrnEntity(GrnDto grnDto);
    GrnDto toGrnDto(GrnEntity grnEntity);
    List<GrnDto> toGrnDtoList(List<GrnEntity> grnEntitiyList);
}
