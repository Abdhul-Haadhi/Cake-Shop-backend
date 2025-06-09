package com.bit.backend.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="Billing_table")
public class BillingFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "User Id")
    private String user;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "Contact Number")
    private String contactNumber;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address")
    private String address;

    public BillingFormEntity() {
    }

    public BillingFormEntity(long id, String name, String user, LocalDate date, String contactNumber, String email, String address) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.date = date;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
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
}
