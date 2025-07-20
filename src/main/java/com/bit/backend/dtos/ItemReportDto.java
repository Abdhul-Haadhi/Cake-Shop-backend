package com.bit.backend.dtos;

public class ItemReportDto {
    private String itemId;
    private String itemName;
    private String category;
    private String expDate;
    private String addedDate;
    private Integer qty;


    public ItemReportDto() {
    }

    public ItemReportDto(String itemId, String itemName, String category, String expDate, String addedDate, Integer qty) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.expDate = expDate;
        this.addedDate = addedDate;
        this.qty = qty;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
