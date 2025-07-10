package com.bit.backend.mappers;


import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.entities.BillingFormEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface BillingFormMapper {
    OrderDetailsDto toBillingFormDto(BillingFormEntity billingFormEntity);
    BillingFormEntity toBillingFormEntity(OrderDetailsDto orderDetailsDto);
    List<OrderDetailsDto> toBillingFormDtoList(List<BillingFormEntity> billingFormEntityList);
}
