package com.bit.backend.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Task_table")
public class TaskFormEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Phone Number")
    private String phoneNumber;

    @Column(name = "Email")
    private String email;

    @Column(name = "Delivery Address")
    private String deliveryAddress;


    public TaskFormEntity() {
    }

    public TaskFormEntity(long id, String name, String phoneNumber, String email, String deliveryAddress) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
