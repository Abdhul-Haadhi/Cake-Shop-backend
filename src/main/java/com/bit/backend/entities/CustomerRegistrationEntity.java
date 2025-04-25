package com.bit.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Cust_Reg")

public class CustomerRegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "customer_category")
    private String customerCategory;

    @Column(name = "loyalty_customer")
    private String loyaltyCustomer;


    public CustomerRegistrationEntity() {
    }

    public CustomerRegistrationEntity(Long id, String customerName, String email, String address, String contactNumber, LocalDate birthday, String customerCategory, String loyaltyCustomer) {
        this.id = id;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.contactNumber = contactNumber;
        this.birthday = birthday;
        this.customerCategory = customerCategory;
        this.loyaltyCustomer = loyaltyCustomer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
