package com.bit.backend.dtos;

public class ItemRegistrationDto {
    private long id;
    private String itemId;
    private String item;
    private String category;
    private Integer unitQuantity;
    private String supplierId;
    private Integer totalCost;
    private Integer totalQuantity;
    private Integer unitCost;

    public ItemRegistrationDto() {
    }

    public ItemRegistrationDto(long id, String itemId, String item, String category, Integer unitQuantity, String supplierId, Integer totalCost, Integer totalQuantity, Integer unitCost) {
        this.id = id;
        this.itemId = itemId;
        this.item = item;
        this.category = category;
        this.unitQuantity = unitQuantity;
        this.supplierId = supplierId;
        this.totalCost = totalCost;
        this.totalQuantity = totalQuantity;
        this.unitCost = unitCost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(Integer unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Integer getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Integer unitCost) {
        this.unitCost = unitCost;
    }
}
