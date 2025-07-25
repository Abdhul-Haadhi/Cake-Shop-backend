package com.bit.backend.dtos;

public class OrderItemDto {
    private Long id;
    private Long orderId;
    private String itemName;
    private int itemQty;
    private Double itemPrice;
    private String size;
    private String customizeNote;
    private String color;

    public OrderItemDto() {
    }

    public OrderItemDto(Long id, Long orderId, String itemName, int itemQty, Double itemPrice, String size, String customizeNote, String color) {
        this.id = id;
        this.orderId = orderId;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
        this.size = size;
        this.customizeNote = customizeNote;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCustomizeNote() {
        return customizeNote;
    }

    public void setCustomizeNote(String customizeNote) {
        this.customizeNote = customizeNote;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
