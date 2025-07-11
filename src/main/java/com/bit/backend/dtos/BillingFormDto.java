package com.bit.backend.dtos;

import java.time.LocalDate;

public class BillingFormDto {

    private long id;
    private String name;
    private String user;
    private LocalDate date;
    private String contactNumber;
    private String email;
    private String address;
    private byte[] receipt;
    private String receiptName;
    private String receiptType;
    private Long orderId;

    public BillingFormDto() {
    }

    public BillingFormDto(long id, String name, String user, LocalDate date, String contactNumber, String email, String address, byte[] receipt, String receiptName, String receiptType, Long orderId) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.date = date;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.receipt = receipt;
        this.receiptName = receiptName;
        this.receiptType = receiptType;
        this.orderId = orderId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
