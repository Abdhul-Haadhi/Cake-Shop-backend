package com.bit.backend.services.impl;

import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.entities.EmployeeRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.EmployeeRegistrationMapper;
import com.bit.backend.repositories.EmployeeRegistrationRepository;
import com.bit.backend.services.EmployeeRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeRegistrationService implements EmployeeRegistrationServiceI {

    private final EmployeeRegistrationRepository employeeRegistrationRepository;
    private final EmployeeRegistrationMapper employeeRegistrationMapper;

    public EmployeeRegistrationService(EmployeeRegistrationRepository employeeRegistrationRepository, EmployeeRegistrationMapper employeeRegistrationMapper) {
        this.employeeRegistrationRepository = employeeRegistrationRepository;
        this.employeeRegistrationMapper = employeeRegistrationMapper;
    }

    @Override
    public EmployeeRegistrationDto addEmployeeRegistrationEntity(EmployeeRegistrationDto employeeRegistrationDto) {

        try {
            System.out.println("*******************************");

            EmployeeRegistrationEntity employeeRegistrationEntity = employeeRegistrationMapper.toEmployeeRegistrationEntity(employeeRegistrationDto);

            EmployeeRegistrationEntity savedItem = employeeRegistrationRepository.save(employeeRegistrationEntity);
            EmployeeRegistrationDto savedDto = employeeRegistrationMapper.toEmployeeRegistrationDto(savedItem);

            return savedDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public List<EmployeeRegistrationDto> getData() {

        try {
            List<EmployeeRegistrationEntity> employeeRegistrationEntityList = employeeRegistrationRepository.findAll();
            List<EmployeeRegistrationDto> employeeRegistrationDtoList = employeeRegistrationMapper.toEmployeeRegistrationDtoList(employeeRegistrationEntityList);
            return employeeRegistrationDtoList;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public EmployeeRegistrationDto updateEmployeeRegistration(long id, EmployeeRegistrationDto employeeRegistrationDto) {

        try {
            Optional<EmployeeRegistrationEntity> optionalEmployeeRegistrationEntity = employeeRegistrationRepository.findById(id);

            if (!optionalEmployeeRegistrationEntity.isPresent()) {
                throw new AppException("Employee Registration does not Exists", HttpStatus.BAD_REQUEST);
            }

            EmployeeRegistrationEntity newEmployeeRegistrationEntity = employeeRegistrationMapper.toEmployeeRegistrationEntity(employeeRegistrationDto);
            newEmployeeRegistrationEntity.setId(id);


            EmployeeRegistrationEntity employeeRegistrationEntity = employeeRegistrationRepository.save(newEmployeeRegistrationEntity);
            EmployeeRegistrationDto responseEmployeeRegistrationDto = employeeRegistrationMapper.toEmployeeRegistrationDto(employeeRegistrationEntity);
            return responseEmployeeRegistrationDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public EmployeeRegistrationDto deleteEmpRegForm(long id) {

        try {
            Optional<EmployeeRegistrationEntity> optionalEmployeeRegistrationEntity = employeeRegistrationRepository.findById(id);

            if (!optionalEmployeeRegistrationEntity.isPresent()) {
                throw new AppException("Employee Registration does not Exists", HttpStatus.BAD_REQUEST);
            }

            employeeRegistrationRepository.deleteById(id);
            return employeeRegistrationMapper.toEmployeeRegistrationDto(optionalEmployeeRegistrationEntity.get());
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
