package com.bit.backend.services;

import com.bit.backend.dtos.GrnDto;

import java.util.List;

public interface GrnServiceI {
    GrnDto addGrnEntity(GrnDto grnDto);
    List<GrnDto> getData();
    GrnDto updateOuterGrn(long id, GrnDto grnDto);
    GrnDto deleteOuterGrn(long id);
}
