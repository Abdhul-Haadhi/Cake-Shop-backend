package com.bit.backend.services;

import com.bit.backend.dtos.ItemRegistrationDto;

import java.util.List;

public interface ItemRegistrationServiceI {
    ItemRegistrationDto addItemRegistrationEntity(ItemRegistrationDto itemRegistrationDto);
    List<ItemRegistrationDto> getData();
    ItemRegistrationDto updateItemRegistration(long id, ItemRegistrationDto itemRegistrationDto);
    ItemRegistrationDto deleteItemRegForm(long id);
}
