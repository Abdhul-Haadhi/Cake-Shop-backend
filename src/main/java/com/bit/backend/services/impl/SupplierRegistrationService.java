package com.bit.backend.services.impl;

import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.dtos.SupplierRegistrationDto;
import com.bit.backend.entities.EmployeeRegistrationEntity;
import com.bit.backend.entities.SupplierRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.EmployeeRegistrationMapper;
import com.bit.backend.mappers.SupplierRegistrationMapper;
import com.bit.backend.repositories.EmployeeRegistrationRepository;
import com.bit.backend.repositories.SupplierRegistrationRepository;
import com.bit.backend.services.SupplierRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierRegistrationService implements SupplierRegistrationServiceI {

    private final SupplierRegistrationRepository supplierRegistrationRepository;
    private final SupplierRegistrationMapper supplierRegistrationMapper;

    public SupplierRegistrationService(SupplierRegistrationRepository supplierRegistrationRepository, SupplierRegistrationMapper supplierRegistrationMapper) {
        this.supplierRegistrationRepository = supplierRegistrationRepository;
        this.supplierRegistrationMapper = supplierRegistrationMapper;
    }

    @Override
    public SupplierRegistrationDto addSupplierRegistrationEntity(SupplierRegistrationDto supplierRegistrationDto) {
        try {
            System.out.println("*******************************");

            SupplierRegistrationEntity supplierRegistrationEntity = supplierRegistrationMapper.toSupplierRegistrationEntity(supplierRegistrationDto);

            SupplierRegistrationEntity savedItem = supplierRegistrationRepository.save(supplierRegistrationEntity);
            SupplierRegistrationDto savedDto = supplierRegistrationMapper.toSupplierRegistrationDto(savedItem);

            return savedDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<SupplierRegistrationDto> getData() {
        try {
            List<SupplierRegistrationEntity> supplierRegistrationEntityList = supplierRegistrationRepository.findAll();
            List<SupplierRegistrationDto> supplierRegistrationDtoList = supplierRegistrationMapper.toSupplierRegistrationDtoList(supplierRegistrationEntityList);
            return supplierRegistrationDtoList;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public SupplierRegistrationDto updateSupplierRegistration(long id, SupplierRegistrationDto supplierRegistrationDto) {
        try {
            Optional<SupplierRegistrationEntity> optionalSupplierRegistrationEntity = supplierRegistrationRepository.findById(id);

            if (!optionalSupplierRegistrationEntity.isPresent()) {
                throw new AppException("Supplier Registration does not Exists", HttpStatus.BAD_REQUEST);
            }

            SupplierRegistrationEntity newSupplierRegistrationEntity = supplierRegistrationMapper.toSupplierRegistrationEntity(supplierRegistrationDto);
            newSupplierRegistrationEntity.setId(id);


            SupplierRegistrationEntity supplierRegistrationEntity = supplierRegistrationRepository.save(newSupplierRegistrationEntity);
            SupplierRegistrationDto responseSupplierRegistrationDto = supplierRegistrationMapper.toSupplierRegistrationDto(supplierRegistrationEntity);
            return responseSupplierRegistrationDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public SupplierRegistrationDto deleteSuppRegForm(long id) {
        try {
            Optional<SupplierRegistrationEntity> optionalSupplierRegistrationEntity = supplierRegistrationRepository.findById(id);

            if (!optionalSupplierRegistrationEntity.isPresent()) {
                throw new AppException("Supplier Registration does not Exists", HttpStatus.BAD_REQUEST);
            }

            supplierRegistrationRepository.deleteById(id);
            return supplierRegistrationMapper.toSupplierRegistrationDto(optionalSupplierRegistrationEntity.get());
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
