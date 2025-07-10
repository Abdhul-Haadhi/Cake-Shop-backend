package com.bit.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Supp_Reg")
public class SupplierRegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_Name")
    private String supplierName;

    @Column(name = "spplier_Id")
    private String supplierID;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String supplierEmailAddress;

    @Column(name = "address")
    private String address;


    public SupplierRegistrationEntity() {
    }

    public SupplierRegistrationEntity(Long id, String supplierName, String supplierID, String contactNumber, String supplierEmailAddress, String address) {
        this.id = id;
        this.supplierName = supplierName;
        this.supplierID = supplierID;
        this.contactNumber = contactNumber;
        this.supplierEmailAddress = supplierEmailAddress;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
