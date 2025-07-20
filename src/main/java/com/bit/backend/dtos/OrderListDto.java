package com.bit.backend.dtos;

public class OrderListDto {
    private int orderId;
    private String itemName;
    private String customerName;
    private String contactNumber;
    private String email;
    private String address;
    private String date;
//    private String orderStatus;


    public OrderListDto() {
    }

    public OrderListDto(int orderId, String itemName, String customerName, String contactNumber, String email, String address, String date) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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
}
