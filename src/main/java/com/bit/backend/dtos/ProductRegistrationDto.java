package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Lob;

public class ProductRegistrationDto {
    private long id;
    private String productId;
    private String product;
    private Integer initialWeight;
    private Integer measurementCategory;
//    private String requiredItems;
//    private Integer usedAmount;
    private String description;
    private Integer finalPrice;
//    private Integer totalCost;
//    private Integer requiredItemsQuantities;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] image;


    public ProductRegistrationDto() {
    }

    public ProductRegistrationDto(long id, String productId, String product, Integer initialWeight, Integer measurementCategory, String description, Integer finalPrice, byte[] image) {
        this.id = id;
        this.productId = productId;
        this.product = product;
        this.initialWeight = initialWeight;
        this.measurementCategory = measurementCategory;
        this.description = description;
        this.finalPrice = finalPrice;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(Integer initialWeight) {
        this.initialWeight = initialWeight;
    }

    public Integer getMeasurementCategory() {
        return measurementCategory;
    }

    public void setMeasurementCategory(Integer measurementCategory) {
        this.measurementCategory = measurementCategory;
    }

    public Integer getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Integer finalPrice) {
        this.finalPrice = finalPrice;
    }


    //    public String getRequiredItems() {
//        return requiredItems;
//    }
//
//    public void setRequiredItems(String requiredItems) {
//        this.requiredItems = requiredItems;
//    }

//    public Integer getUsedAmount() {
//        return usedAmount;
//    }
//
//    public void setUsedAmount(Integer usedAmount) {
//        this.usedAmount = usedAmount;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

//    public Integer getTotalCost() {
//        return totalCost;
//    }
//
//    public void setTotalCost(Integer totalCost) {
//        this.totalCost = totalCost;
//    }
//
//    public Integer getRequiredItemsQuantities() {
//        return requiredItemsQuantities;
//    }
//
//    public void setRequiredItemsQuantities(Integer requiredItemsQuantities) {
//        this.requiredItemsQuantities = requiredItemsQuantities;
//    }
}
