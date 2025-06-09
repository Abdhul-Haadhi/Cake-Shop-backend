package com.bit.backend.services.impl;


import com.bit.backend.dtos.GrnDto;
import com.bit.backend.entities.GrnAddedEntity;
import com.bit.backend.entities.GrnEntity;
import com.bit.backend.entities.StockEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.GrnMapper;
import com.bit.backend.repositories.GrnAddedRepository;
import com.bit.backend.repositories.GrnRepository;
import com.bit.backend.repositories.StockRepository;
import com.bit.backend.services.GrnServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrnService implements GrnServiceI {

    private final GrnRepository grnRepository;
    private final GrnAddedRepository grnAddedRepository;
    private final GrnMapper grnMapper;
    private final StockRepository stockRepository;

    public GrnService(GrnRepository grnRepository, GrnAddedRepository grnAddedRepository, GrnMapper grnMapper, StockRepository stockRepository) {
        this.grnRepository = grnRepository;
        this.grnAddedRepository = grnAddedRepository;
        this.grnMapper = grnMapper;
        this.stockRepository = stockRepository;
    }

    @Override
    public GrnDto addGrnEntity(GrnDto grnDto) {
        System.out.println("*************In Backend***************");

        GrnEntity grnEntity = grnMapper.toGrnEntity(grnDto);


        GrnEntity savedItem = grnRepository.save(grnEntity);

        GrnDto savedDto = grnMapper.toGrnDto(savedItem);
        return savedDto;
    }

    @Override
    public List<GrnDto> getData() {
        List<GrnEntity> grnEntityList = grnRepository.findAll();
        List<GrnDto> grnDtoList = grnMapper.toGrnDtoList(grnEntityList);
        return grnDtoList;
    }


    @Override
    public GrnDto deleteOuterGrn(long id) {
        Optional<GrnEntity> optionalGrnEntity =  grnRepository.findById(id);

        List<GrnAddedEntity> grnAddedEntityList = grnAddedRepository.findAllByGRNNO(id);

        grnRepository.deleteById(id);

        grnAddedRepository.deleteAll(grnAddedEntityList);

        for (GrnAddedEntity grnAddedEntity : grnAddedEntityList) {
            Optional<StockEntity> optionalStockEntity = stockRepository.findByItemIDo(grnAddedEntity.getItemID());
            int totalQty = Optional.ofNullable(grnAddedRepository.findSumOfQtyByItemId(grnAddedEntity.getItemID())).orElse(0);

            System.out.println(totalQty + " total quantity");

            optionalStockEntity.ifPresent(stockEntity -> {
                System.out.println(stockEntity.getId() + " " + stockEntity.getStockItemName() + " found");
                System.out.println(stockEntity.getStockItemName());
                stockEntity.setQty(totalQty);
                stockRepository.save(stockEntity);
            });
        }

        if (!optionalGrnEntity.isPresent()) {
            throw  new AppException("Stock entity not exists", HttpStatus.BAD_REQUEST);
        }

        GrnDto deleteDto = grnMapper.toGrnDto(optionalGrnEntity.get());
        return deleteDto;
    }

    @Override
    public GrnDto updateOuterGrn(long id, GrnDto grnDto) {

        Optional<GrnEntity> optionalGrnEntity =  grnRepository.findById(id);

        if (!optionalGrnEntity.isPresent()) {
            throw  new AppException("GRN entity not exists", HttpStatus.BAD_REQUEST);
        }

        GrnEntity newGrnEntity = grnMapper.toGrnEntity(grnDto);

        //save from repository
        newGrnEntity.setGrnno(id);
        GrnEntity grnEntity = grnRepository.save(newGrnEntity);

        //return type is dto and again convert from entity to dto
        GrnDto savedDto = grnMapper.toGrnDto(grnEntity);
        return savedDto;
    }
}
