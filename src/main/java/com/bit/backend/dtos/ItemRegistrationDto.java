package com.bit.backend.dtos;

public class ItemRegistrationDto {
    private long id;
    private String itemId;
    private String itemName;
    private String category;


    public ItemRegistrationDto() {
    }

    public ItemRegistrationDto(long id, String itemId, String itemName, String category) {
        this.id = id;
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
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
}
