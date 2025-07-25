package com.bit.backend.dtos;

import java.util.List;

public class ProductItemsMapDto {
    private Long id;
    private Long product;
    private Double initialWeight;
    private String productId;
    private String productName;
    private List<ProductItemsDto> itemList;

    public ProductItemsMapDto() {
    }

    public ProductItemsMapDto(Long id, Long product, Double initialWeight, String productId, String productName, List<ProductItemsDto> itemList) {
        this.id = id;
        this.product = product;
        this.initialWeight = initialWeight;
        this.productId = productId;
        this.productName = productName;
        this.itemList = itemList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Double getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(Double initialWeight) {
        this.initialWeight = initialWeight;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<ProductItemsDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<ProductItemsDto> itemList) {
        this.itemList = itemList;
    }
}
