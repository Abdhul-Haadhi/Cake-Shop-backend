package com.bit.backend.dtos;

public class TaskFormDto {
    private long Id;
    private String name;
    private int phoneNumber;
    private String email;
    private String deliveryAddress;


    public TaskFormDto() {
    }

    public TaskFormDto(long id, String name, int phoneNumber, String email, String deliveryAddress) {
        Id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
