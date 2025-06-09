package com.bit.backend.services;

import com.bit.backend.dtos.BillingFormDto;

import java.util.List;

public interface BillingFormServiceI {
    BillingFormDto addBillingFormEntity(BillingFormDto billingFormDto);
    List<BillingFormDto> getData();
    BillingFormDto updateBillingForm(long id, BillingFormDto billingFormDto);
    BillingFormDto deleteBillingForm(long id);
}
