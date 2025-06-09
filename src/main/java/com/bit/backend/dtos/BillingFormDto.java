package com.bit.backend.dtos;

import java.time.LocalDate;

public class BillingFormDto {
    private long Id;
    private String user;
    private LocalDate date;
    private String name;
    private String email;
    private Integer contactNumber;
    private String address;

    public BillingFormDto() {
    }

    public BillingFormDto(long id, String user, LocalDate date, String name, String email, Integer contactNumber, String address) {
        Id = id;
        this.user = user;
        this.date = date;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
