package com.bit.backend.mappers;

import com.bit.backend.dtos.BillingFormDto;
import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.dtos.OrderItemDto;
import com.bit.backend.dtos.OrderListDto;
import com.bit.backend.entities.BillingFormEntity;
import com.bit.backend.entities.OrderDetailsEntity;
import com.bit.backend.entities.OrderSummaryEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface OrderDetailsMapper {

    OrderDetailsEntity toOrderDetailsEntity(OrderDetailsDto orderDetailsDto);
    List<OrderSummaryEntity> toOrderSummaryEntityList(List<OrderItemDto> orderItemDtoList);

//    @Mapping(source = "billingFormDto.customerName", target = "customerName")
//    @Mapping(source = "billingFormDto.email", target = "email")
//    @Mapping(source = "billingFormDto.address", target = "address")
//    @Mapping(source = "billingFormDto.contactNumber", target = "contactNumber")
//    @Mapping(source = "billingFormDto.receiptName", target = "receiptName")
//    @Mapping(source = "billingFormDto.receiptType", target = "receiptType")

    BillingFormEntity toBillingFormEntity(OrderDetailsDto orderDetailsDto);
    List<OrderItemDto> toOrderItemDtoList(List<OrderSummaryEntity> orderSummaryEntityList);
    BillingFormDto toBillingFormDto(BillingFormEntity billingFormEntity);
    BillingFormEntity toBillingFormEntity(BillingFormDto billingFormDto);
    OrderDetailsDto toOrderDetailsDto(OrderDetailsEntity orderDetailsEntity);
//    OrderDetailsEntity toOrderDetailsEntity(OrderDetailsDto orderDetailsDto);
    List<OrderListDto> toOrderListDtoList(List<OrderDetailsEntity> orderDetailsEntityList);

    OrderListDto toOrderListDto(OrderDetailsEntity orderDetailsEntity);
}
