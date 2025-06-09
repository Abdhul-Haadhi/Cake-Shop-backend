package com.bit.backend.controllers;


import com.bit.backend.dtos.GrnDto;
import com.bit.backend.dtos.ItemRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.GrnServiceI;
import com.bit.backend.services.ItemRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class GrnController {

    private final GrnServiceI grnServiceI;
    private final ItemRegistrationServiceI itemRegistrationServiceI;

    public GrnController(GrnServiceI grnServiceI, ItemRegistrationServiceI itemRegistrationServiceI) {
        this.grnServiceI = grnServiceI;
        this.itemRegistrationServiceI = itemRegistrationServiceI;
    }

    @PostMapping("/grn")
    public ResponseEntity<GrnDto> addForm(@RequestBody GrnDto grnDto){

        GrnDto grnDtoResponse = grnServiceI.addGrnEntity(grnDto);
        return ResponseEntity.created(URI.create("/grn"+ grnDtoResponse.getGrnno())).body(grnDtoResponse);
//       return ResponseEntity.ok().body(formDemoDtoResponse);
    }

    @GetMapping("/allgrn")
    public ResponseEntity<List<GrnDto>> getGrnDtos(){
        try{
            List<GrnDto> grnDtoList = grnServiceI.getData();
            return ResponseEntity.ok().body(grnDtoList);
        } catch (Exception e) {
            throw new AppException(" Get mapping Failed " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/grn")
    public ResponseEntity<List<GrnDto>> getGRNs(){
        try{
            List<GrnDto> grnDtoList = grnServiceI.getData();
            return ResponseEntity.ok().body(grnDtoList);
        } catch (Exception e) {
            throw new AppException(" Get mapping Failed " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/grn/get-item")
    public ResponseEntity<List<ItemRegistrationDto>> getItems(){
        List<ItemRegistrationDto> itemDtoList = itemRegistrationServiceI.getData();
        return ResponseEntity.ok().body(itemDtoList);
    }

    @PutMapping("/outeredit/{id}")
    public ResponseEntity<GrnDto> updateOuterGRN(@PathVariable long id, @RequestBody GrnDto grnDto){
        GrnDto responseGrnDto = grnServiceI.updateOuterGrn(id,grnDto);
        return ResponseEntity.ok(responseGrnDto);
    }

    @DeleteMapping("/deleteOuter/{id}")
    public ResponseEntity<GrnDto> deleteOuterGrn(@PathVariable long id){
        GrnDto grnDto = grnServiceI.deleteOuterGrn(id);
        return ResponseEntity.ok(grnDto);
    }
}
