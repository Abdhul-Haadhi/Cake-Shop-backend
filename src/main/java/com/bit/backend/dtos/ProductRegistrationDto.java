package com.bit.backend.dtos;

public class ProductRegistrationDto {
    private long id;
    private String productId;
    private String product;
    private Integer initialWeight;
    private String requiredItems;
    private Integer usedAmount;
    private String description;
    private String image;
    private Integer totalCost;
    private Integer requiredItemsQuantities;


    public ProductRegistrationDto() {
    }

    public ProductRegistrationDto(long id, String productId, String product, Integer initialWeight, String requiredItems, Integer usedAmount, String description, String image, Integer totalCost, Integer requiredItemsQuantities) {
        this.id = id;
        this.productId = productId;
        this.product = product;
        this.initialWeight = initialWeight;
        this.requiredItems = requiredItems;
        this.usedAmount = usedAmount;
        this.description = description;
        this.image = image;
        this.totalCost = totalCost;
        this.requiredItemsQuantities = requiredItemsQuantities;
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

    public String getRequiredItems() {
        return requiredItems;
    }

    public void setRequiredItems(String requiredItems) {
        this.requiredItems = requiredItems;
    }

    public Integer getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(Integer usedAmount) {
        this.usedAmount = usedAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getRequiredItemsQuantities() {
        return requiredItemsQuantities;
    }

    public void setRequiredItemsQuantities(Integer requiredItemsQuantities) {
        this.requiredItemsQuantities = requiredItemsQuantities;
    }
}
