package com.bit.backend.dtos;

public class SupplierRegistrationDto {
    private long id;
    private String supplierName;
    private String supplierID;
    private String contactNumber;
    private String supplierEmailAddress;
    private String address;

    public SupplierRegistrationDto() {
    }

    public SupplierRegistrationDto(long id, String supplierName, String supplierID, String contactNumber, String supplierEmailAddress, String address) {
        this.id = id;
        this.supplierName = supplierName;
        this.supplierID = supplierID;
        this.contactNumber = contactNumber;
        this.supplierEmailAddress = supplierEmailAddress;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getSupplierEmailAddress() {
        return supplierEmailAddress;
    }

    public void setSupplierEmailAddress(String supplierEmailAddress) {
        this.supplierEmailAddress = supplierEmailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
