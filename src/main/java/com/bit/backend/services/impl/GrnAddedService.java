package com.bit.backend.services.impl;


import com.bit.backend.dtos.GrnAddedDto;
import com.bit.backend.entities.GrnAddedEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.GrnAddedMapper;
import com.bit.backend.repositories.GrnAddedRepository;
import com.bit.backend.services.GrnAddedServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrnAddedService implements GrnAddedServiceI {

    private final GrnAddedRepository grnAddedRepository;
    private final GrnAddedMapper grnAddedMapper;

    public GrnAddedService(GrnAddedRepository grnAddedRepository, GrnAddedMapper grnAddedMapper) {
        this.grnAddedRepository = grnAddedRepository;
        this.grnAddedMapper = grnAddedMapper;
    }


    @Override
    public GrnAddedDto addGrnAddedEntity(GrnAddedDto grnAddedDto) {
        System.out.println("*************In Backend***************");

        GrnAddedEntity grnAddedEntity = grnAddedMapper.toGrnAddedEntity(grnAddedDto);

        GrnAddedEntity savedItem = grnAddedRepository.save(grnAddedEntity);
//
//        //return type is dto and again convert from entity to dto
        GrnAddedDto savedDto = grnAddedMapper.toGrnAddedDto(savedItem);
        return savedDto;
    }

    @Override
    public List<GrnAddedDto> getData(long grnno) {
        List<GrnAddedEntity> grnAddedEntityList = grnAddedRepository.findAllByGRNNO(grnno);
        List<GrnAddedDto> grnAddedDtoList = grnAddedMapper.toGrnAddedDtoList(grnAddedEntityList);
        return grnAddedDtoList;
    }

    @Override
    public GrnAddedDto updateInnerGrn(long id, GrnAddedDto grnAddedDto) {

        Optional<GrnAddedEntity> optionalGrnAddedEntity =  grnAddedRepository.findById(id);

        if (!optionalGrnAddedEntity.isPresent()) {
            throw  new AppException("GRN added entity not exists", HttpStatus.BAD_REQUEST);
        }

        GrnAddedEntity newGrnAddedEntity = grnAddedMapper.toGrnAddedEntity(grnAddedDto);

        newGrnAddedEntity.setId(id);
        GrnAddedEntity grnAddedEntity = grnAddedRepository.save(newGrnAddedEntity);

        GrnAddedDto savedDto = grnAddedMapper.toGrnAddedDto(grnAddedEntity);
        return savedDto;
    }

    @Override
    public GrnAddedDto deleteAddedGrn(long id) {
        Optional<GrnAddedEntity> optionalGrnAddedEntity =  grnAddedRepository.findById(id);

        if (!optionalGrnAddedEntity.isPresent()) {
            throw  new AppException("GRN added entity not exists", HttpStatus.BAD_REQUEST);
        }

        grnAddedRepository.deleteById(id);

        GrnAddedDto deleteDto = grnAddedMapper.toGrnAddedDto(optionalGrnAddedEntity.get());

        return deleteDto;
    }
}
