package com.bit.backend.dtos;

import java.time.LocalDate;

public class CustomerRegistrationDto {
    private long id;
    private String customerName;
    private String email;
    private String address;
    private String contactNumber;
    private LocalDate birthday;
    private String customerCategory;
    private String loyaltyCustomer;

    public CustomerRegistrationDto() {
    }

    public CustomerRegistrationDto(long id, String customerName, String email, String address, String contactNumber, LocalDate birthday, String customerCategory, String loyaltyCustomer) {
        this.id = id;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.contactNumber = contactNumber;
        this.birthday = birthday;
        this.customerCategory = customerCategory;
        this.loyaltyCustomer = loyaltyCustomer;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }

    public String getLoyaltyCustomer() {
        return loyaltyCustomer;
    }

    public void setLoyaltyCustomer(String loyaltyCustomer) {
        this.loyaltyCustomer = loyaltyCustomer;
    }
}
