package com.bit.backend.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Item_Reg")
public class ItemRegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "item")
    private String item;

    @Column(name = "category")
    private String category;

    @Column(name = "unit_quantity")
    private Integer unitQuantity;

    @Column(name = "supplier_id")
    private String supplierId;

    @Column(name = "total_cost")
    private Integer totalCost;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @Column(name = "unit_cost")
    private Integer unitCost;


    public ItemRegistrationEntity() {
    }

    public ItemRegistrationEntity(Long id, String itemId, String item, String category, Integer unitQuantity, String supplierId, Integer totalCost, Integer totalQuantity, Integer unitCost) {
        this.id = id;
        this.itemId = itemId;
        this.item = item;
        this.category = category;
        this.unitQuantity = unitQuantity;
        this.supplierId = supplierId;
        this.totalCost = totalCost;
        this.totalQuantity = totalQuantity;
        this.unitCost = unitCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(Integer unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Integer getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Integer unitCost) {
        this.unitCost = unitCost;
    }
}
