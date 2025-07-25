package com.bit.backend.dtos;

public class StockDto {
    private  Long id;
    private int stockItemID;
    private Double qty;
    private String stockItemName;

    public StockDto() {
    }

    public StockDto(Long id, int stockItemID, Double qty, String stockItemName) {
        this.id = id;
        this.stockItemID = stockItemID;
        this.qty = qty;
        this.stockItemName = stockItemName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStockItemID() {
        return stockItemID;
    }

    public void setStockItemID(int stockItemID) {
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
}
