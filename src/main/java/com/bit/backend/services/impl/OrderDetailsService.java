package com.bit.backend.services.impl;


import com.bit.backend.dtos.BillingFormDto;
import com.bit.backend.dtos.OrderDetailsDto;
import com.bit.backend.dtos.OrderListDto;
import com.bit.backend.dtos.ProductRegistrationDto;
import com.bit.backend.entities.BillingFormEntity;
import com.bit.backend.entities.OrderDetailsEntity;
import com.bit.backend.entities.OrderSummaryEntity;
import com.bit.backend.entities.ProductRegistrationEntity;
import com.bit.backend.enums.OrderStatusEnum;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.BillingFormMapper;
import com.bit.backend.mappers.OrderDetailsMapper;
import com.bit.backend.repositories.BillingFormRepository;
import com.bit.backend.repositories.OrderDetailsRepository;
import com.bit.backend.repositories.OrderSummaryRepository;
import com.bit.backend.services.OrderDetailsServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsService implements OrderDetailsServiceI {

    private final OrderDetailsRepository orderDetailsRepository;
    private final OrderSummaryRepository orderSummaryRepository;
    private  final BillingFormRepository billingFormRepository;
    private final OrderDetailsMapper orderDetailsMapper;


    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository,
                               OrderDetailsMapper orderDetailsMapper,
                               OrderSummaryRepository orderSummaryRepository,
                               BillingFormRepository billingFormRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.orderDetailsMapper = orderDetailsMapper;
        this.orderSummaryRepository = orderSummaryRepository;
        this.billingFormRepository = billingFormRepository;
    }

    @Override
    public OrderDetailsDto addOrderDetailsEntity(OrderDetailsDto orderDetailsDto, MultipartFile file) {
        try {
            System.out.println("*******************************");

            OrderDetailsEntity orderDetailsEntity = orderDetailsMapper.toOrderDetailsEntity(orderDetailsDto);

            orderDetailsEntity.setStatus(OrderStatusEnum.Pending);

            List<OrderSummaryEntity> orderSummaryEntityList = orderDetailsMapper.toOrderSummaryEntityList(orderDetailsDto.getItems());

            BillingFormEntity billingFormEntity = orderDetailsMapper.toBillingFormEntity(orderDetailsDto.getBillingFormDto());

            billingFormEntity.setReceipt(file.getBytes());
            billingFormEntity.setReceiptName(file.getOriginalFilename());
            billingFormEntity.setReceiptType(file.getContentType());

            billingFormEntity.setDate(orderDetailsDto.getDate());
            billingFormEntity.setUser(orderDetailsDto.getUser());

            System.out.println(orderDetailsDto);

            OrderDetailsEntity savedOrderDetailsEntity = orderDetailsRepository.save(orderDetailsEntity);

            for(OrderSummaryEntity orderSummaryEntity: orderSummaryEntityList) {
                orderSummaryEntity.setOrderId(savedOrderDetailsEntity.getId());
            }

            billingFormEntity.setOrderId(savedOrderDetailsEntity.getId());

            List<OrderSummaryEntity> savedOrderSummaryEntityList = orderSummaryRepository.saveAll(orderSummaryEntityList);
            System.out.println(billingFormEntity);
            BillingFormEntity savedBillingFormEntity = billingFormRepository.save(billingFormEntity);

            OrderDetailsDto savedOrderDetailsDto = this.orderDetailsMapper.toOrderDetailsDto(savedOrderDetailsEntity);
            savedOrderDetailsDto.setBillingFormDto(orderDetailsMapper.toBillingFormDto(savedBillingFormEntity));
            savedOrderDetailsDto.setItems(orderDetailsMapper.toOrderItemDtoList(savedOrderSummaryEntityList));
            return savedOrderDetailsDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @Override
//    public BillingFormDto addBillingFormEntity(BillingFormDto billingFormDto) {
//        try {
//            BillingFormEntity billingFormEntity = orderDetailsMapper.toBillingFormEntity(billingFormDto);
//            BillingFormEntity savedBillingFormEntity = billingFormRepository.save(billingFormEntity);
//            BillingFormDto savedDto = orderDetailsMapper.toBillingFormDto(savedBillingFormEntity);
//            return savedDto;
//        }
//        catch (Exception e) {
//            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


//    @Override
//    public OrderDetailsDto addOrderDetailsEntity(OrderDetailsDto orderDetailsDto) {
//        return null;
//    }

    @Override
    public List<OrderListDto> filterByDateRange(LocalDate startDate, LocalDate endDate) {
        try {
            List<Object[]> rows = orderDetailsRepository.findAllOrderDetailsRawByDateRange(startDate,endDate);
            List<OrderListDto> orderListDtoList = new ArrayList<>();

            for (Object[] row : rows) {
                OrderListDto dto = new OrderListDto(
                        ((Number) row[0]).intValue(),
                        (String) row[1],
                        (String) row[2],
                        (String) row[3],
                        (String) row[4],
                        (String) row[5],
                        String.valueOf(row[6]),
                        (String) row[7],
                        (String) row[8],
                        (String) row[9],
                        (String) row[10],
                        (String) row[11],
                        (String) row[12]
//                        (LocalDateTime) row[6]
//                        (String) row[7]
                );
                orderListDtoList.add(dto);

//                dto.setId(((Number) row[0]).longValue());
//                dto.set((String) row[2]);
//                dto.setCustomerName((String) row[1]);
//                dto.setContactNumber((String) row[3]);
//                dto.setEmail((String) row[4]);
//                dto.setAddress((String) row[5]);
//                dto.setDate(((Timestamp) row[6]).toLocalDateTime());
//                orderDetailsDtoList.add(dto);
            }
            return orderListDtoList;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<OrderListDto> getItemListData() {
        try {
            List<Object[]> rows = orderDetailsRepository.findAllOrderDetailsRaw();
            List<OrderListDto> orderListDtoList = new ArrayList<>();

            for (Object[] row : rows) {
                OrderListDto dto = new OrderListDto(
                        ((Number) row[0]).intValue(),
                        (String) row[1],
                        (String) row[2],
                        (String) row[3],
                        (String) row[4],
                        (String) row[5],
                        String.valueOf(row[6]),
                        (String) row[7],
                        (String) row[8],
                        (String) row[9],
                        (String) row[10],
                        (String) row[11],
                        (String) row[12]
                );
                orderListDtoList.add(dto);
            }
            return orderListDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @Override
//    public List<OrderListDto> filterByDateRange(LocalDate startDate, LocalDate endDate) {
//        List<OrderDetailsEntity> entities = orderDetailsRepository.findAllByDateRange(startDate, endDate);
//        return orderDetailsMapper.toOrderListDtoList(entities);
//    }

    @Override
    public OrderListDto updateOrderStatus(Integer orderId, String newStatus) {
        try {
            OrderDetailsEntity order = orderDetailsRepository.findById(Long.valueOf(orderId)).orElseThrow(() -> new RuntimeException("Order not found"));

            order.setStatus(OrderStatusEnum.valueOf(newStatus));
            OrderDetailsEntity updatedOrder = orderDetailsRepository.save(order);

            OrderDetailsEntity updatedEntity = orderDetailsRepository.save(order);

            OrderListDto updatedDto = orderDetailsMapper.toOrderListDto(updatedEntity);

            return updatedDto;

//            return new OrderListDto(
//                    updatedOrder.getId().intValue(),
//                    null, // itemName
//                    null, // customerName
//                    null, // contactNumber
//                    null, // email
//                    null, // address
//                    updatedOrder.getDate().toString(),
//                    updatedOrder.getStatus().toString()
//            );
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public OrderDetailsDto deleteOrderDetails(long id) {
        return null;
    }




}
