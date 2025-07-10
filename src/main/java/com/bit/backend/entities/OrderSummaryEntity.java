package com.bit.backend.entities;


import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "order_summary")
public class OrderSummaryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "items", columnDefinition = "TEXT")
    private String itemsJson;

    @Column(name = "total_price")
    private Integer totalPrice;

    public OrderSummaryEntity() {
    }

    public OrderSummaryEntity(Long id, String itemsJson, Integer totalPrice) {
        this.id = id;
        this.itemsJson = itemsJson;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemsJson() {
        return itemsJson;
    }

    public void setItemsJson(String itemsJson) {
        this.itemsJson = itemsJson;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
