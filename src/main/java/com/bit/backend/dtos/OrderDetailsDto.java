package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class OrderDetailsDto {
    private long id;
    private String user;
    private Integer totalPrice;
    private List<OrderItemDto> items;
//    private String selectedSize;
//    private Integer quantities;
    private LocalDate date;
    private String name;
    private String email;
    private String contactNumber;
    private String address;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] receipt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String receiptName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String receiptType;

    public OrderDetailsDto() {
    }

    public OrderDetailsDto(long id, String user, Integer totalPrice, List<OrderItemDto> items, LocalDate date, String name, String email, String contactNumber, String address, byte[] receipt, String receiptName, String receiptType) {
        this.id = id;
        this.user = user;
        this.totalPrice = totalPrice;
        this.items = items;
        this.date = date;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
        this.receipt = receipt;
        this.receiptName = receiptName;
        this.receiptType = receiptType;
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

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getReceipt() {
        return receipt;
    }

    public void setReceipt(byte[] receipt) {
        this.receipt = receipt;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }
}
