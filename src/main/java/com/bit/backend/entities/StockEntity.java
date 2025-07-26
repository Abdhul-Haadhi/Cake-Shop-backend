package com.bit.backend.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "stock")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stockItemID")
    private String stockItemID;

    @Column(name = "stockItemName")
    private String stockItemName;

    @Column(name = "qty")
    private Double qty;

    @Column(name = "threshold_qty")
    private Double thresholdQty;

    public StockEntity() {
    }

    public StockEntity(Long id, String stockItemID, String stockItemName, Double qty, Double thresholdQty) {
        this.id = id;
        this.stockItemID = stockItemID;
        this.stockItemName = stockItemName;
        this.qty = qty;
        this.thresholdQty = thresholdQty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockItemID() {
        return stockItemID;
    }

    public void setStockItemID(String stockItemID) {
        this.stockItemID = stockItemID;
    }

    public String getStockItemName() {
        return stockItemName;
    }

    public void setStockItemName(String stockItemName) {
        this.stockItemName = stockItemName;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getThresholdQty() {
        return thresholdQty;
    }

    public void setThresholdQty(Double thresholdQty) {
        this.thresholdQty = thresholdQty;
    }
}
