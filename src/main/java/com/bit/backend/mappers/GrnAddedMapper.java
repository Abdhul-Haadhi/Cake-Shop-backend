package com.bit.backend.mappers;


import com.bit.backend.dtos.GrnAddedDto;
import com.bit.backend.entities.GrnAddedEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface GrnAddedMapper {

    GrnAddedEntity toGrnAddedEntity(GrnAddedDto grnAddedDto);
    GrnAddedDto toGrnAddedDto(GrnAddedEntity grnAddedEntity);
    List<GrnAddedDto> toGrnAddedDtoList(List<GrnAddedEntity> grnAddedEntityList);
}
