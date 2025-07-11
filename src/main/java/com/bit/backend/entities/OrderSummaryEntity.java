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
    private int itemQty;

    @Column(name = "item_price")
    private Double itemPrice;

    public OrderSummaryEntity() {
    }

    public OrderSummaryEntity(Long id, Long orderId, String itemName, int itemQty, Double itemPrice) {
        this.id = id;
        this.orderId = orderId;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
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

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
