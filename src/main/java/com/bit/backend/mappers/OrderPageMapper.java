package com.bit.backend.mappers;


import com.bit.backend.dtos.FeedbackAndRatingDto;
import com.bit.backend.dtos.OrderPageDto;
import com.bit.backend.entities.FeedbackAndRatingEntity;
import com.bit.backend.entities.OrderPageEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true))

public interface OrderPageMapper {
    OrderPageDto toOrderPageDto(OrderPageEntity orderPageEntity);
    OrderPageEntity toOrderPageEntity(OrderPageDto orderPageDto);

    List<OrderPageDto> toOrderPageDtoList(List<OrderPageEntity> orderPageEntityList);
}
