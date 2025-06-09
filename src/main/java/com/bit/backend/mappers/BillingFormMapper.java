package com.bit.backend.mappers;


import com.bit.backend.dtos.BillingFormDto;
import com.bit.backend.dtos.TaskFormDto;
import com.bit.backend.entities.BillingFormEntity;
import com.bit.backend.entities.TaskFormEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface BillingFormMapper {
    BillingFormDto toBillingFormDto(BillingFormEntity billingFormEntity);
    BillingFormEntity toBillingFormEntity(BillingFormDto billingFormDto);
    List<BillingFormDto> toBillingFormDtoList(List<BillingFormEntity> billingFormEntityList);
}
