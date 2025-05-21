package com.bit.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Supp_Reg")
public class SupplierRegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_Name")
    private String companyName;

    @Column(name = "reg_Number")
    private String businessRegNumber;

    @Column(name = "contact_Name")
    private String contactPersonName;

    @Column(name = "job_Title")
    private String contactPersonDesignation;

    @Column(name = "contact_number")
    private Integer contactPersonPhoneNumber;

    @Column(name = "email")
    private String contactPersonEmailAddress;

    @Column(name = "address")
    private String address;


    public SupplierRegistrationEntity() {
    }

    public SupplierRegistrationEntity(Long id, String companyName, String businessRegNumber, String contactPersonName, String contactPersonDesignation, Integer contactPersonPhoneNumber, String contactPersonEmailAddress, String address) {
        this.id = id;
        this.companyName = companyName;
        this.businessRegNumber = businessRegNumber;

        this.contactPersonName = contactPersonName;
        this.contactPersonDesignation = contactPersonDesignation;
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
        this.contactPersonEmailAddress = contactPersonEmailAddress;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
