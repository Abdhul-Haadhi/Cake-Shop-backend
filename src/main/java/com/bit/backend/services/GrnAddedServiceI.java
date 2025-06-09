package com.bit.backend.services;


import com.bit.backend.dtos.GrnAddedDto;

import java.util.List;

public interface GrnAddedServiceI {
    GrnAddedDto addGrnAddedEntity(GrnAddedDto grnAddedDto);
    List<GrnAddedDto> getData(long grnno);
    GrnAddedDto updateInnerGrn(long id, GrnAddedDto grnAddedDto);
    GrnAddedDto deleteAddedGrn(long id);
}
