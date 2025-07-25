package com.bit.backend.entities;


import jakarta.persistence.*;

import java.util.List;

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

//    @Column(name = "measurement_category")
//    private String measurementCategory;

//    @Column(name = "required_items")
//    private String requiredItems;

//    @Column(name = "used_amount")
//    private String usedAmount;

    @Column(name = "description")
    private String description;

    @Column(name = "final_price")
    private String finalPrice;

    @Column(name = "colors")
    private String colors;

    //    @Column(name = "image", columnDefinition = "LONGBLOB")
    @Lob
    @Column(name = "image")
    private byte[] image;

//    @Column(name = "total_cost")
//    private String totalCost;

//    @Column(name = "required_quantities")
//    private String requiredItemsQuantities;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_type")
    private String imageType;


    public ProductRegistrationEntity() {
    }

    public ProductRegistrationEntity(Long id, String productId, String product, String initialWeight, String description, String finalPrice, String colors, byte[] image, String imageName, String imageType) {
        this.id = id;
        this.productId = productId;
        this.product = product;
        this.initialWeight = initialWeight;
        this.description = description;
        this.finalPrice = finalPrice;
        this.colors = colors;
        this.image = image;
        this.imageName = imageName;
        this.imageType = imageType;
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

//    public String getMeasurementCategory() {
//        return measurementCategory;
//    }
//
//    public void setMeasurementCategory(String measurementCategory) {
//        this.measurementCategory = measurementCategory;
//    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    //    public String getRequiredItems() {
//        return requiredItems;
//    }
//
//    public void setRequiredItems(String requiredItems) {
//        this.requiredItems = requiredItems;
//    }
//
//    public String getUsedAmount() {
//        return usedAmount;
//    }
//
//    public void setUsedAmount(String usedAmount) {
//        this.usedAmount = usedAmount;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    //    public String getTotalCost() {
//        return totalCost;
//    }
//
//    public void setTotalCost(String totalCost) {
//        this.totalCost = totalCost;
//    }
//
//    public String getRequiredItemsQuantities() {
//        return requiredItemsQuantities;
//    }
//
//    public void setRequiredItemsQuantities(String requiredItemsQuantities) {
//        this.requiredItemsQuantities = requiredItemsQuantities;
//    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}
