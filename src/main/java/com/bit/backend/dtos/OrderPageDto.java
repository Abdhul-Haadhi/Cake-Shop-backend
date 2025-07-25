package com.bit.backend.dtos;

import java.math.BigInteger;
import java.time.LocalDate;

public class OrderPageDto {
    private long id;
    private String user;
    private LocalDate date;
    private String customizeNote;
    private Integer size;
    private Integer price;
    private String color;
    private Integer quantity;
    private Integer productId;

    public OrderPageDto() {
    }

    public OrderPageDto(long id, String user, LocalDate date, String customizeNote, Integer size, Integer price, String color, Integer quantity, Integer productId) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.customizeNote = customizeNote;
        this.size = size;
        this.price = price;
        this.color = color;
        this.quantity = quantity;
        this.productId = productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomizeNote() {
        return customizeNote;
    }

    public void setCustomizeNote(String customizeNote) {
        this.customizeNote = customizeNote;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
