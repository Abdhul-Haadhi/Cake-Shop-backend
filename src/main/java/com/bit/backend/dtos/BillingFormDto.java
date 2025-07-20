package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class BillingFormDto {

    private long id;
    private String customerName;
    private Long user;
    private LocalDate date;
    private String contactNumber;
    private String email;
    private String address;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private byte[] receipt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String receiptName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String receiptType;
    private Long orderId;

    public BillingFormDto() {
    }

    public BillingFormDto(long id, String customerName, Long user, LocalDate date, String contactNumber, String email, String address, byte[] receipt, String receiptName, String receiptType, Long orderId) {
        this.id = id;
        this.customerName = customerName;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
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
