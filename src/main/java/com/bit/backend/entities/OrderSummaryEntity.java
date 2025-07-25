package com.bit.backend.entities;


import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "order_summary")
public class OrderSummaryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_qty")
    private String itemQty;

    @Column(name = "item_price")
    private String itemPrice;

    @Column(name = "selected_size")
    private String size;

    @Column(name = "selected_color")
    private String color;

    @Column(name = "customize_note")
    private String customizeNote;

    public OrderSummaryEntity() {
    }

    public OrderSummaryEntity(Long id, Long orderId, String itemName, String itemQty, String itemPrice, String size, String color, String customizeNote) {
        this.id = id;
        this.orderId = orderId;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
        this.size = size;
        this.color = color;
        this.customizeNote = customizeNote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemQty() {
        return itemQty;
    }

    public void setItemQty(String itemQty) {
        this.itemQty = itemQty;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCustomizeNote() {
        return customizeNote;
    }

    public void setCustomizeNote(String customizeNote) {
        this.customizeNote = customizeNote;
    }
}
