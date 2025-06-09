package com.bit.backend.services.impl;

import com.bit.backend.dtos.ItemRegistrationDto;
import com.bit.backend.entities.ItemRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.ItemRegistrationMapper;
import com.bit.backend.repositories.ItemRegistrationRepository;
import com.bit.backend.services.ItemRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemRegistrationService implements ItemRegistrationServiceI {

    private final ItemRegistrationRepository itemRegistrationRepository;
    private final ItemRegistrationMapper itemRegistrationMapper;

    public ItemRegistrationService(ItemRegistrationRepository itemRegistrationRepository, ItemRegistrationMapper itemRegistrationMapper) {
        this.itemRegistrationRepository = itemRegistrationRepository;
        this.itemRegistrationMapper = itemRegistrationMapper;
    }

    @Override
    public ItemRegistrationDto addItemRegistrationEntity(ItemRegistrationDto itemRegistrationDto) {
        try {
            System.out.println("*******************************");

            ItemRegistrationEntity itemRegistrationEntity = itemRegistrationMapper.toItemRegistrationEntity(itemRegistrationDto);
            ItemRegistrationEntity savedItem = itemRegistrationRepository.save(itemRegistrationEntity);
            ItemRegistrationDto savedDto = itemRegistrationMapper.toItemRegistrationDto(savedItem);

            return savedDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<ItemRegistrationDto> getData() {
        try {
            List<ItemRegistrationEntity> itemRegistrationEntityList = itemRegistrationRepository.findAll();
            List<ItemRegistrationDto> itemRegistrationDtoList = itemRegistrationMapper.toItemRegistrationDtoList(itemRegistrationEntityList);
            return itemRegistrationDtoList;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ItemRegistrationDto updateItemRegistration(long id, ItemRegistrationDto itemRegistrationDto) {
        try {
            Optional<ItemRegistrationEntity> optionalItemRegistrationEntity = itemRegistrationRepository.findById(id);

            if (!optionalItemRegistrationEntity.isPresent()){
                throw new AppException("Item registration does not exists",HttpStatus.BAD_REQUEST);
            }

            ItemRegistrationEntity newItemRegistrationEntity = itemRegistrationMapper.toItemRegistrationEntity(itemRegistrationDto);
            newItemRegistrationEntity.setId(id);

            ItemRegistrationEntity itemRegistrationEntity = itemRegistrationRepository.save(newItemRegistrationEntity);
            ItemRegistrationDto responseItemRegistrationDto = itemRegistrationMapper.toItemRegistrationDto(itemRegistrationEntity);
            return responseItemRegistrationDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ItemRegistrationDto deleteItemRegForm(long id) {
        try {
            Optional<ItemRegistrationEntity> optionalItemRegistrationEntity = itemRegistrationRepository.findById(id);

            if (!optionalItemRegistrationEntity.isPresent()){
                throw new AppException("Item registration does not exists",HttpStatus.BAD_REQUEST);
            }
            itemRegistrationRepository.deleteById(id);
            return itemRegistrationMapper.toItemRegistrationDto(optionalItemRegistrationEntity.get());
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
