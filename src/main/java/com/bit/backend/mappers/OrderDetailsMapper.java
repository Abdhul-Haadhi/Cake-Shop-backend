package com.bit.backend.mappers;

import com.bit.backend.dtos.BillingFormDto;
import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.dtos.OrderItemDto;
import com.bit.backend.entities.BillingFormEntity;
import com.bit.backend.entities.OrderDetailsEntity;
import com.bit.backend.entities.OrderSummaryEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface OrderDetailsMapper {

    OrderDetailsEntity toOrderDetailsEntity(OrderDetailsDto orderDetailsDto);
    List<OrderSummaryEntity> toOrderSummaryEntityList(List<OrderItemDto> orderItemDtoList);
    BillingFormEntity toBillingFormEntity(OrderDetailsDto orderDetailsDto);
    List<OrderItemDto> toOrderItemDtoList(List<OrderSummaryEntity> orderSummaryEntityList);
    BillingFormDto toBillingFormDto(BillingFormEntity billingFormEntity);
    OrderDetailsDto toOrderDetailsDto(OrderDetailsEntity orderDetailsEntity);
}
