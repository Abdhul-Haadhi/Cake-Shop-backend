package com.bit.backend.controllers;


import com.bit.backend.dtos.GrnAddedDto;
import com.bit.backend.dtos.ItemRegistrationDto;
import com.bit.backend.dtos.StockDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.ItemRegistrationServiceI;
import com.bit.backend.services.StockServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ItemRegistrationController {
    private final ItemRegistrationServiceI itemRegistrationServiceI;
    private final StockServiceI stockServiceI;

    public ItemRegistrationController(ItemRegistrationServiceI itemRegistrationServiceI, StockServiceI stockServiceI) {
        this.itemRegistrationServiceI = itemRegistrationServiceI;
        this.stockServiceI = stockServiceI;
    }

    @PostMapping("/item-registration")

    public ResponseEntity<ItemRegistrationDto> addForm(@RequestBody ItemRegistrationDto itemRegistrationDto){
        try {
            ItemRegistrationDto itemRegistrationDtoResponse = itemRegistrationServiceI.addItemRegistrationEntity(itemRegistrationDto);
            return ResponseEntity.created(URI.create("/item-registration"+itemRegistrationDtoResponse.getId())).body(itemRegistrationDtoResponse);
        }catch (Exception e){
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getQty/{itemID}")
    public ResponseEntity<StockDto> getQty(@PathVariable long itemID){
        try{

            StockDto stockDto = stockServiceI.getQty(itemID);
//            if (stockDTO == null) {
//                // Return 0 if no quantity found
//            }

            return ResponseEntity.ok().body(stockDto);
        } catch (Exception e) {
            throw new AppException(" Get mapping Failed " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/stock")
    public ResponseEntity<StockDto> addStock(@RequestBody StockDto stockDto){

        StockDto stockaddedresponse = stockServiceI.addStock(stockDto);
        return ResponseEntity.created(URI.create("/stock"+stockaddedresponse.getId())).body(stockaddedresponse);
    }


    @GetMapping("/item")
    public ResponseEntity<List<ItemRegistrationDto>> getData(){
        try {
            List<ItemRegistrationDto> itemRegistrationDtoList = itemRegistrationServiceI.getData();
            return ResponseEntity.ok(itemRegistrationDtoList);
        }
        catch (Exception e){
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/stockupdate")
    public ResponseEntity<List<StockDto>> updateStock(@RequestBody List<GrnAddedDto> grnAddedDtos) {
        try {
            List<StockDto> stockDtolist = stockServiceI.updateStock(grnAddedDtos);
            return ResponseEntity.ok().body(stockDtolist);
        } catch (Exception e) {
            throw new AppException(" PUT mapping Failed " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/item-registration/{id}")
    public ResponseEntity<ItemRegistrationDto> updateItemRegForm(@PathVariable Long id, @RequestBody ItemRegistrationDto itemRegistrationDto){
        try {
            ItemRegistrationDto responseItemRegistrationDto = itemRegistrationServiceI.updateItemRegistration(id,itemRegistrationDto);
            return ResponseEntity.ok(responseItemRegistrationDto);
        }
        catch (Exception e){
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/item-registration/{id}")
    public ResponseEntity<ItemRegistrationDto> deleteItemRegForm(@PathVariable Long id){
        try {
            ItemRegistrationDto itemRegistrationDto = itemRegistrationServiceI.deleteItemRegForm(id);
            return ResponseEntity.ok(itemRegistrationDto);
        }
        catch (Exception e){
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/stockupdateEdit")
    public ResponseEntity<StockDto> updateStockEdit(@RequestBody GrnAddedDto grnAddedDto) {
        try {
            StockDto stockDtolist = stockServiceI.updateStockEdit(grnAddedDto);
            return ResponseEntity.ok().body(stockDtolist);
        } catch (Exception e) {
            throw new AppException(" PUT mapping Failed " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
