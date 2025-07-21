package com.bit.backend.services;

import com.bit.backend.dtos.BillingFormDto;
import com.bit.backend.dtos.ItemReportDto;
import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.dtos.OrderListDto;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderDetailsServiceI {
    OrderDetailsDto addOrderDetailsEntity(OrderDetailsDto orderDetailsDto, MultipartFile file);
//    BillingFormDto addBillingFormEntity(BillingFormDto billingFormDto);
//    List<OrderDetailsDto> getData();
    OrderDetailsDto updateOrderDetails(long id, OrderDetailsDto orderDetailsDto);
    OrderDetailsDto deleteOrderDetails(long id);
    List<OrderListDto> getItemListData();
    List<OrderListDto> filterByDateRange(LocalDateTime startDate, LocalDateTime endDate))
}
