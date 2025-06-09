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

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "category")
    private String category;


    public ItemRegistrationEntity() {
    }

    public ItemRegistrationEntity(Long id, String itemId, String itemName, String category) {
        this.id = id;
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
