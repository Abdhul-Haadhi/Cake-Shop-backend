package com.bit.backend.dtos;

public class OrderListDto {
    private Integer orderId;
    private String itemName;
    private String customerName;
    private String contactNumber;
    private String email;
    private String address;
    private String date;
    private String status;


    public OrderListDto() {
    }

    public OrderListDto(Integer orderId, String itemName, String customerName, String contactNumber, String email, String address, String date, String status) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.date = date;
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
