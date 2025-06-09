package com.bit.backend.dtos;

public class StockDto {
    private  Long id;
    private int stockItemID;
    private int qty;
    private String stockItemName;

    public StockDto() {
    }

    public StockDto(Long id, int stockItemID, int qty, String stockItemName) {
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getStockItemName() {
        return stockItemName;
    }

    public void setStockItemName(String stockItemName) {
        this.stockItemName = stockItemName;
    }
}
