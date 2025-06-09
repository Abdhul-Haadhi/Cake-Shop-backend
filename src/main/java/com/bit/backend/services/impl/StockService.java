package com.bit.backend.services.impl;


import com.bit.backend.dtos.GrnAddedDto;
import com.bit.backend.dtos.StockDto;
import com.bit.backend.entities.StockEntity;
import com.bit.backend.mappers.StockMapper;
import com.bit.backend.repositories.GrnAddedRepository;
import com.bit.backend.repositories.StockRepository;
import com.bit.backend.services.StockServiceI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService implements StockServiceI {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;
    private final GrnAddedRepository grnAddedRepository;

    public StockService(StockRepository stockRepository, StockMapper stockMapper, GrnAddedRepository grnAddedRepository) {
        this.stockRepository = stockRepository;
        this.stockMapper = stockMapper;
        this.grnAddedRepository = grnAddedRepository;
    }


    @Override
    public List<StockDto> updateStock(List<GrnAddedDto> grnList) {
        List<StockDto> savedItems = new ArrayList<>();

        for (GrnAddedDto dto : grnList) {
            Optional<StockEntity> optionalStockEntity = stockRepository.findByItemIDo(dto.getItemID());

            if (optionalStockEntity.isPresent()) {
                System.out.println(optionalStockEntity + "found");
                StockEntity newEntity = optionalStockEntity.get();

                int updatedQty = newEntity.getQty() + dto.getQty();
                newEntity.setQty(updatedQty);
                StockEntity savedItem = stockRepository.save(newEntity);
                StockDto stockDto = stockMapper.toStockDto(savedItem);
                savedItems.add(stockDto);
            }
        }
        return savedItems;
    }

    @Override
    public StockDto  updateStockEdit(GrnAddedDto grnAddedDto) {

        Optional<StockEntity> optionalStockEntity = stockRepository.findByItemIDo(grnAddedDto.getItemID());
        Integer totalQty = grnAddedRepository.findSumOfQtyByItemId(grnAddedDto.getItemID());
        if (totalQty == null) {
            totalQty = 0;
        }
        System.out.println(totalQty + " total quantity");
        StockEntity newEntity = null;
        if (optionalStockEntity.isPresent()) {
//            System.out.println(optionalStockEntity.get().getId() + " " + optionalStockEntity.get().getStockItemName() + " found");
            newEntity = optionalStockEntity.get();
            int updatedQty = totalQty;
            newEntity.setQty(updatedQty);
            stockRepository.save(newEntity);
        }
        StockEntity savedItem = stockRepository.save(newEntity);
        StockDto stockDto = stockMapper.toStockDto(savedItem);
        return stockDto;
    }


    @Override
    public StockDto addStock(StockDto stockDto) {
        System.out.println("*************In Backend***************");

        //need to convert dto to entity type to save from repository
        StockEntity stockEntity= stockMapper.toStockEntity(stockDto);

        //save from repository
        StockEntity savedItem = stockRepository.save(stockEntity);

        //return type is dto and again convert from entity to dto
        StockDto savedDto = stockMapper.toStockDto(savedItem);
        return savedDto;
    }

    @Override
    public List<StockDto> getData() {
        List<StockEntity> stockEntitiyList = stockRepository.findAll();
        List<StockDto> stockDtoList = stockMapper.toStockDtoList(stockEntitiyList);
        return stockDtoList;
    }

    @Override
    public StockDto getQty(long itemID) {
        StockEntity stockEntity = stockRepository.findByItemID(itemID);
        StockDto stockDto = stockMapper.toStockDto(stockEntity);
        return stockDto;
    }
}
