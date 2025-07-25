package com.bit.backend.services.impl;


import com.bit.backend.dtos.OrderPageDto;
import com.bit.backend.dtos.ProductItemsDto;
import com.bit.backend.dtos.ProductItemsMapDto;
import com.bit.backend.entities.OrderPageEntity;
import com.bit.backend.entities.ProductItemsEntity;
import com.bit.backend.entities.ProductItemsMapEntity;
import com.bit.backend.entities.StockEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.OrderPageMapper;
import com.bit.backend.repositories.OrderPageRepository;
import com.bit.backend.repositories.ProductItemMapRepository;
import com.bit.backend.repositories.StockRepository;
import com.bit.backend.services.OrderPageServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderPageService implements OrderPageServiceI {

    private final OrderPageRepository orderPageRepository;
    private final OrderPageMapper orderPageMapper;
    private final ProductItemMapRepository productItemMapRepository;
    private final StockRepository stockRepository;

    public OrderPageService(OrderPageRepository orderPageRepository, OrderPageMapper orderPageMapper,
                            ProductItemMapRepository productItemMapRepository, StockRepository stockRepository) {
        this.orderPageRepository = orderPageRepository;
        this.orderPageMapper = orderPageMapper;
        this.productItemMapRepository = productItemMapRepository;
        this.stockRepository = stockRepository;
    }


    @Override
    public OrderPageDto addOrderPageEntity(OrderPageDto orderPageDto) {
        try {
            System.out.println("*******************************");

            String[] stockAdjustStatus = this.adjustStock(orderPageDto);

            if (stockAdjustStatus.length > 0 && Integer.parseInt(stockAdjustStatus[0]) == -1) {
                throw new AppException("Stock does not have required quantity for the item " + stockAdjustStatus[1], HttpStatus.INTERNAL_SERVER_ERROR);
            }

            if (stockAdjustStatus.length > 0 && Integer.parseInt(stockAdjustStatus[0]) < 0) {
                throw new AppException("Error while adjusting the stocks! Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            OrderPageEntity orderPageEntity = orderPageMapper.toOrderPageEntity(orderPageDto);

            OrderPageEntity savedItem = orderPageRepository.save(orderPageEntity);
            OrderPageDto savedDto = orderPageMapper.toOrderPageDto(savedItem);

            return savedDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public String[] adjustStock(OrderPageDto orderPageDto) {
        try {
            long prodId = orderPageDto.getProductId();
            List<ProductItemsMapEntity> productItemsMapEntityList = this.productItemMapRepository.findByProduct(prodId);
            ProductItemsMapEntity productItemsMapEntity = productItemsMapEntityList.get(0);
            Double initialWeight = productItemsMapEntity.getInitialWeight(); // 100g
            Integer orderSize = orderPageDto.getSize(); // 2000g
            Double sizeToWeightRatio = orderSize.doubleValue()/initialWeight;
            Integer orderQty = orderPageDto.getQuantity(); // 10
            List<ProductItemsEntity> productItemsEntities = productItemsMapEntity.getItemList();
            List<StockEntity> stockEntities = new ArrayList<>();

            for (ProductItemsEntity productItemsEntity: productItemsEntities) {
                Double usedQuantity = productItemsEntity.getItemQuantity() * sizeToWeightRatio * orderQty;
                StockEntity stockEntity = stockRepository.findByItemID(productItemsEntity.getItemId());
                Double availableQty = stockEntity.getQty();
                Double remainingQty = availableQty - usedQuantity;

                if (remainingQty < 0) {
                    String[] status = {"-1", productItemsEntity.getItemName()};
                    return status;
                }

                StockEntity newStockEntity = stockEntity;
                newStockEntity.setQty(remainingQty);
                stockEntities.add(newStockEntity);
            }
            stockRepository.saveAll(stockEntities);
        } catch (Exception e) {
            String[] status = {"-2", "-2"};
            return status;
        }
        String[] status = {"1", "1"};
        return status;
    }

    @Override
    public List<OrderPageDto> getData() {
        try {
            List<OrderPageEntity> orderPageEntityList = orderPageRepository.findAll();
            List<OrderPageDto> orderPageDtosList = orderPageMapper.toOrderPageDtoList(orderPageEntityList);
            return orderPageDtosList;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public OrderPageDto updateOrderPage(long id, OrderPageDto orderPageDto) {
        try {
            Optional<OrderPageEntity> optionalOrderPageEntity = orderPageRepository.findById(id);

            if (!optionalOrderPageEntity.isPresent()) {
                throw new AppException("Order page does not Exists", HttpStatus.BAD_REQUEST);
            }

            OrderPageEntity newOrderPageEntity = orderPageMapper.toOrderPageEntity(orderPageDto);
            newOrderPageEntity.setId(id);


            OrderPageEntity orderPageEntity = orderPageRepository.save(newOrderPageEntity);
            OrderPageDto responseOrderPageDto = orderPageMapper.toOrderPageDto(orderPageEntity);
            return responseOrderPageDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public OrderPageDto deleteOrderPageForm(long id) {
        try {

            Optional<OrderPageEntity> optionalOrderPageEntity = orderPageRepository.findById(id);

            if (!optionalOrderPageEntity.isPresent()) {
                throw new AppException("Order does not exists",HttpStatus.BAD_REQUEST);
            }

            OrderPageDto orderPageDto = orderPageMapper.toOrderPageDto(optionalOrderPageEntity.get());

            String[] stockAdjustStatus = this.adjustStockOnDeletion(orderPageDto);

            if (stockAdjustStatus.length > 0 && Integer.parseInt(stockAdjustStatus[0]) < 0) {
                orderPageRepository.deleteById(id); // delete the order even there is an issue with stock
                throw new AppException("Error while adjusting the stocks " + stockAdjustStatus[1], HttpStatus.INTERNAL_SERVER_ERROR);
            }
            orderPageRepository.deleteById(id);
            return orderPageMapper.toOrderPageDto(optionalOrderPageEntity.get());
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public String[] adjustStockOnDeletion(OrderPageDto orderPageDto) {
        try {
            long prodId = orderPageDto.getProductId();
            List<ProductItemsMapEntity> productItemsMapEntityList = this.productItemMapRepository.findByProduct(prodId);
            ProductItemsMapEntity productItemsMapEntity = productItemsMapEntityList.get(0);
            Double initialWeight = productItemsMapEntity.getInitialWeight(); // 100g
            Integer orderSize = orderPageDto.getSize(); // 2000g
            Double sizeToWeightRatio = orderSize.doubleValue()/initialWeight;
            Integer orderQty = orderPageDto.getQuantity(); // 10
            List<ProductItemsEntity> productItemsEntities = productItemsMapEntity.getItemList();
            List<StockEntity> stockEntities = new ArrayList<>();

            for (ProductItemsEntity productItemsEntity: productItemsEntities) {
                Double usedQuantity = productItemsEntity.getItemQuantity() * sizeToWeightRatio * orderQty;
                StockEntity stockEntity = stockRepository.findByItemID(productItemsEntity.getItemId());
                Double availableQty = stockEntity.getQty();
                Double remainingQty = availableQty + usedQuantity;

                if (remainingQty < 0) {
                    String[] status = {"-1", productItemsEntity.getItemName()};
                    return status;
                }

                StockEntity newStockEntity = stockEntity;
                newStockEntity.setQty(remainingQty);
                stockEntities.add(newStockEntity);
            }
            stockRepository.saveAll(stockEntities);
        } catch (Exception e) {
            String[] status = {"-2", "-2"};
            return status;
        }
        String[] status = {"1", "1"};
        return status;
    }

    @Override
    public List<OrderPageDto> getOrderUserData(Long id) {
        try {
            List<OrderPageEntity> orderPageEntityList = orderPageRepository.findByUser(Long.toString(id));
            List<OrderPageDto> orderPageDtosList = orderPageMapper.toOrderPageDtoList(orderPageEntityList);
            return orderPageDtosList;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
