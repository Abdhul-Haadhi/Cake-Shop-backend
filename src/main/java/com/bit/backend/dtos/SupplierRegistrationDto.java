package com.bit.backend.dtos;

import java.time.LocalDate;

public class SupplierRegistrationDto {
    private long id;
    private String companyName;
    private String businessRegNumber;
    private String supplierID;
    private String contactPersonName;
    private String contactPersonDesignation;
    private Integer contactPersonPhoneNumber;
    private String contactPersonEmailAddress;
    private String address;

    public SupplierRegistrationDto() {
    }

    public SupplierRegistrationDto(long id, String companyName, String businessRegNumber, String supplierID, String contactPersonName, String contactPersonDesignation, Integer contactPersonPhoneNumber, String contactPersonEmailAddress, String address) {
        this.id = id;
        this.companyName = companyName;
        this.businessRegNumber = businessRegNumber;
        this.supplierID = supplierID;
        this.contactPersonName = contactPersonName;
        this.contactPersonDesignation = contactPersonDesignation;
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
        this.contactPersonEmailAddress = contactPersonEmailAddress;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBusinessRegNumber() {
        return businessRegNumber;
    }

    public void setBusinessRegNumber(String businessRegNumber) {
        this.businessRegNumber = businessRegNumber;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonDesignation() {
        return contactPersonDesignation;
    }

    public void setContactPersonDesignation(String contactPersonDesignation) {
        this.contactPersonDesignation = contactPersonDesignation;
    }

    public Integer getContactPersonPhoneNumber() {
        return contactPersonPhoneNumber;
    }

    public void setContactPersonPhoneNumber(Integer contactPersonPhoneNumber) {
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
    }

    public String getContactPersonEmailAddress() {
        return contactPersonEmailAddress;
    }

    public void setContactPersonEmailAddress(String contactPersonEmailAddress) {
        this.contactPersonEmailAddress = contactPersonEmailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
