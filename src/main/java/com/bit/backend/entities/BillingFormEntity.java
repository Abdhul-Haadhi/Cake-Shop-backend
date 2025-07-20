package com.bit.backend.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="Billing_table")
public class BillingFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "User_id")
    private Long user;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address")
    private String address;


    @Column(name = "receipt")
    @Lob
    private byte[] receipt;

    @Column(name = "receipt_name")
    private String receiptName;

    @Column(name = "receipt_type")
    private String receiptType;

    @Column(name = "order_id")
    private Long orderId;

    public BillingFormEntity() {
    }

    public BillingFormEntity(long id, String customerName, Long user, LocalDate date, String contactNumber, String email, String address, byte[] receipt, String receiptName, String receiptType, Long orderId) {
        this.id = id;
        this.customerName = customerName;
        this.user = user;
        this.date = date;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.receipt = receipt;
        this.receiptName = receiptName;
        this.receiptType = receiptType;
        this.orderId = orderId;
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

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
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

    public byte[] getReceipt() {
        return receipt;
    }

    public void setReceipt(byte[] receipt) {
        this.receipt = receipt;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
