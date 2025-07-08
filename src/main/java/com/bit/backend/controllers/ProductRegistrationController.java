package com.bit.backend.controllers;

import com.bit.backend.dtos.ProductRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.ProductRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
public class ProductRegistrationController {
    private final ProductRegistrationServiceI productRegistrationServiceI;

    public ProductRegistrationController(ProductRegistrationServiceI productRegistrationServiceI) {
        this.productRegistrationServiceI = productRegistrationServiceI;
    }

    @PostMapping(value = "/product-registration", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductRegistrationDto> addForm(@RequestBody ProductRegistrationDto productRegistrationDto) {

        try {
            ProductRegistrationDto productRegistrationDtoResponse = productRegistrationServiceI.addProductRegistrationEntity(productRegistrationDto);
            return ResponseEntity.created(URI.create("/product-registration"+productRegistrationDtoResponse.getId())).body(productRegistrationDtoResponse);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = {"/product-registration"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ProductRegistrationDto> addForm(@RequestPart("prodRegForm") ProductRegistrationDto productRegistrationDto,
                                                          @RequestPart("image") MultipartFile file){
        if (file == null || file.isEmpty()) {
            throw new AppException("Item image file is not found", HttpStatus.BAD_REQUEST);
        }
        try {
            productRegistrationDto.setImage(file.getBytes());
            productRegistrationDto.setImageName(file.getOriginalFilename());
            productRegistrationDto.setImageType(file.getContentType());
            ProductRegistrationDto saved = productRegistrationServiceI.addProductRegistrationEntity(productRegistrationDto);

            return ResponseEntity.created(URI.create("/product-registration/" + saved.getId())).body(saved);

        }
        catch (Exception e){
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product-registration")
    public ResponseEntity<List<ProductRegistrationDto>> getData() {

        try {
            List<ProductRegistrationDto> productRegistrationDtoList = productRegistrationServiceI.getData();
            return ResponseEntity.ok(productRegistrationDtoList);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/featured-products")
    public ResponseEntity<List<ProductRegistrationDto>> getAllProducts() {

        try {
            List<ProductRegistrationDto> productRegistrationDtoList = productRegistrationServiceI.getData();
            return ResponseEntity.ok(productRegistrationDtoList);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cart-page/{id}")
    public ResponseEntity<List<ProductRegistrationDto>> getCartProducts(@PathVariable Long id) {

        try {
            List<ProductRegistrationDto> productRegistrationDtoList = productRegistrationServiceI.getData();
            return ResponseEntity.ok(productRegistrationDtoList);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product-registration/{id}")
    public ResponseEntity<ProductRegistrationDto> updateProdRegForm(@PathVariable Long id,
                                                                    @RequestPart("prodRegForm") ProductRegistrationDto productRegistrationDto,
                                                                    @RequestPart("image") MultipartFile file) {

        try {
            productRegistrationDto.setImage(file.getBytes());
            productRegistrationDto.setImageName(file.getOriginalFilename());
            productRegistrationDto.setImageType(file.getContentType());
            ProductRegistrationDto responseProductRegistrationDto = productRegistrationServiceI.updateProductRegistration(id,productRegistrationDto);
            return ResponseEntity.ok(responseProductRegistrationDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/product-registration/{id}")
    public ResponseEntity<ProductRegistrationDto> deleteProdRegForm(@PathVariable Long id) {

        try {
            ProductRegistrationDto productRegistrationDto = productRegistrationServiceI.deleteProdRegForm(id);
            return ResponseEntity.ok(productRegistrationDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
