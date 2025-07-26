package com.bit.backend.services;

import com.bit.backend.dtos.BillingFormDto;
import com.bit.backend.dtos.ItemReportDto;
import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.dtos.OrderListDto;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderDetailsServiceI {
    OrderDetailsDto addOrderDetailsEntity(OrderDetailsDto orderDetailsDto, MultipartFile file);
//    BillingFormDto addBillingFormEntity(BillingFormDto billingFormDto);
//    List<OrderDetailsDto> getData();
    OrderListDto updateOrderStatus(Integer orderId, String status);
//    OrderDetailsDto deleteOrderDetails(long id);
    List<OrderListDto> getItemListData();
    List<OrderListDto> filterByDateRange(LocalDate startDate, LocalDate endDate);
//    OrderListDto deleteOrderList(long id);
//    OrderListDto editOrderListData(Integer orderId, OrderListDto dto);
}
