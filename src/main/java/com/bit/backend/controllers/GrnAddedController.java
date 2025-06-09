package com.bit.backend.controllers;


import com.bit.backend.dtos.GrnAddedDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.GrnAddedServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class GrnAddedController {

    private final GrnAddedServiceI grnAddedServiceI;

    public GrnAddedController(GrnAddedServiceI grnAddedServiceI) {
        this.grnAddedServiceI = grnAddedServiceI;
    }

    @PostMapping("/inner")
    public ResponseEntity<GrnAddedDto> addForm(@RequestBody GrnAddedDto grnAddedDto){

        GrnAddedDto grnAddedDtoResponse = grnAddedServiceI.addGrnAddedEntity(grnAddedDto);
        return ResponseEntity.created(URI.create("/grn"+ grnAddedDtoResponse.getId())).body(grnAddedDtoResponse);
    }

    @GetMapping("/get-inner/{grnno}")
    public ResponseEntity<List<GrnAddedDto>> getGRNs(@PathVariable long grnno){
        try{
            List<GrnAddedDto> grnAddedDtoList = grnAddedServiceI.getData(grnno);
            return ResponseEntity.ok().body(grnAddedDtoList);
        } catch (Exception e) {
            throw new AppException(" Get mapping Failed " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/innergrn/{id}")
    public ResponseEntity<GrnAddedDto> updateInnerGrn(@PathVariable long id, @RequestBody GrnAddedDto grnAddedDto){
        GrnAddedDto responseGrnAddedDto = grnAddedServiceI.updateInnerGrn(id, grnAddedDto);
        return ResponseEntity.ok(responseGrnAddedDto);
    }

    @DeleteMapping("/innergrn/{id}")
    public ResponseEntity<GrnAddedDto> deleteAddedGRN(@PathVariable long id){
        GrnAddedDto grnAddedDto = grnAddedServiceI.deleteAddedGrn(id);
        return ResponseEntity.ok(grnAddedDto);
    }

}
