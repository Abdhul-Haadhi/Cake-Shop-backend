package com.bit.backend.services.impl;


import com.bit.backend.dtos.BillingFormDto;
import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.entities.BillingFormEntity;
import com.bit.backend.entities.CustomerRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.BillingFormMapper;
import com.bit.backend.mappers.CustomerRegistrationMapper;
import com.bit.backend.repositories.BillingFormRepository;
import com.bit.backend.repositories.CustomerRegistrationRepository;
import com.bit.backend.services.BillingFormServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingFormService implements BillingFormServiceI {

    private final BillingFormRepository billingFormRepository;
    private final BillingFormMapper billingFormMapper;

    public BillingFormService(BillingFormRepository billingFormRepository, BillingFormMapper billingFormMapper) {
        this.billingFormRepository = billingFormRepository;
        this.billingFormMapper = billingFormMapper;
    }

    @Override
    public BillingFormDto addBillingFormEntity(BillingFormDto billingFormDto) {
        try {
            System.out.println("*******************************");

            BillingFormEntity billingFormEntity = billingFormMapper.toBillingFormEntity(billingFormDto);

            BillingFormEntity savedItem = billingFormRepository.save(billingFormEntity);

            BillingFormDto savedDto = billingFormMapper.toBillingFormDto(savedItem);

            return savedDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<BillingFormDto> getData() {
        try {
            List<BillingFormEntity> billingFormEntityList = billingFormRepository.findAll();
            List<BillingFormDto> billingFormDtoList = billingFormMapper.toBillingFormDtoList(billingFormEntityList);
            return billingFormDtoList;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public BillingFormDto updateBillingForm(long id, BillingFormDto billingFormDto) {
        return null;
    }

    @Override
    public BillingFormDto deleteBillingForm(long id) {
        return null;
    }
}
