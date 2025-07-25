package com.bit.backend.dtos;

public class ProductItemsDto {
    private Long id;
    private Long itemId;
    private String category;
    private String itemName;
    private Double itemQuantity;

    public ProductItemsDto() {
    }

    public ProductItemsDto(Long id, Long itemId, String category, String itemName, Double itemQuantity) {
        this.id = id;
        this.itemId = itemId;
        this.category = category;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
