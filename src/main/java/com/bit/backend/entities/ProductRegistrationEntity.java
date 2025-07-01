package com.bit.backend.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Prod_Reg")
public class ProductRegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product")
    private String product;

    @Column(name = "ini_weight")
    private String initialWeight;

    @Column(name = "required_items")
    private String requiredItems;

    @Column(name = "used_amount")
    private String usedAmount;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "total_cost")
    private String totalCost;

    @Column(name = "required_quantities")
    private String requiredItemsQuantities;

    public ProductRegistrationEntity() {
    }

    public ProductRegistrationEntity(Long id, String productId, String product, String initialWeight, String requiredItems, String usedAmount, String description, String image, String totalCost, String requiredItemsQuantities) {
        this.id = id;
        this.productId = productId;
        this.product = product;
        this.initialWeight = initialWeight;
        this.requiredItems = requiredItems;
        this.usedAmount = usedAmount;
        this.description = description;
        this.image = image;
        this.totalCost = totalCost;
        this.requiredItemsQuantities = requiredItemsQuantities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(String initialWeight) {
        this.initialWeight = initialWeight;
    }

    public String getRequiredItems() {
        return requiredItems;
    }

    public void setRequiredItems(String requiredItems) {
        this.requiredItems = requiredItems;
    }

    public String getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(String usedAmount) {
        this.usedAmount = usedAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getRequiredItemsQuantities() {
        return requiredItemsQuantities;
    }

    public void setRequiredItemsQuantities(String requiredItemsQuantities) {
        this.requiredItemsQuantities = requiredItemsQuantities;
    }
}
