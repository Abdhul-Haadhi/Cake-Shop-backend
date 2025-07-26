package com.bit.backend.dtos;

public class StockDto {
    private Long id;
    private String stockItemID;
    private Double qty;
    private String stockItemName;
    private Double thresholdQty;

    public StockDto() {
    }

    public StockDto(Long id, String stockItemID, Double qty, String stockItemName, Double thresholdQty) {
        this.id = id;
        this.stockItemID = stockItemID;
        this.qty = qty;
        this.stockItemName = stockItemName;
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

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public String getStockItemName() {
        return stockItemName;
    }

    public void setStockItemName(String stockItemName) {
        this.stockItemName = stockItemName;
    }

    public Double getThresholdQty() {
        return thresholdQty;
    }

    public void setThresholdQty(Double thresholdQty) {
        this.thresholdQty = thresholdQty;
    }
}
