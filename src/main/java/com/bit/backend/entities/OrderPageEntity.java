package com.bit.backend.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Order_table")
public class OrderPageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user")
    private String user;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "customize_Note")
    private String customizeNote;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "size")
    private Integer size;

    @Column(name = "price")
    private Integer price;

    @Column(name = "color")
    private String color;

    @Column(name = "product_id")
    private Integer productId;

    public OrderPageEntity() {
    }

    public OrderPageEntity(Long id, String user, LocalDate date, String customizeNote, Integer quantity, Integer size, Integer price, String color, Integer productId) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.customizeNote = customizeNote;
        this.quantity = quantity;
        this.size = size;
        this.price = price;
        this.color = color;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCustomizeNote() {
        return customizeNote;
    }

    public void setCustomizeNote(String customizeNote) {
        this.customizeNote = customizeNote;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
