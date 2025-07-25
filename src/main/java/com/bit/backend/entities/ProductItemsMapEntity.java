package com.bit.backend.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_item_map")
public class ProductItemsMapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product")
    private Long product;

    @Column(name = "initial_weight")
    private Double initialWeight;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @OneToMany(mappedBy = "productItemsMapEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProductItemsEntity> itemList = new ArrayList<>();

    public ProductItemsMapEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public List<ProductItemsEntity> getItemList() {
        return itemList;
    }

    public void setItemList(List<ProductItemsEntity> itemList) {
        this.itemList.clear();

        if (itemList != null) {
            itemList.forEach(this::addItems);
        }
        this.itemList = itemList;
    }

    public void addItems(ProductItemsEntity productItemsEntity) {
        itemList.add(productItemsEntity);
        productItemsEntity.setProductItemsMapEntity(this);
    }

    public void removeItems(ProductItemsEntity productItemsEntity) {
        itemList.remove(productItemsEntity);
        productItemsEntity.setProductItemsMapEntity(null);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(Double initialWeight) {
        this.initialWeight = initialWeight;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
