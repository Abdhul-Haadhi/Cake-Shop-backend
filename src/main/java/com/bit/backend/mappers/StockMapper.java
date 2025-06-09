package com.bit.backend.mappers;


import com.bit.backend.dtos.StockDto;
import com.bit.backend.entities.StockEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface StockMapper {
    StockEntity toStockEntity(StockDto stockDto);
//    StockDto toStockDto(Optional<StockEntity> stockEntity);
    List<StockDto> toStockDtoList(List<StockEntity> stockEntitiyList);

    StockDto toStockDto(StockEntity savedItem);
}
