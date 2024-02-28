package com.example.productputdelt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

    @Entity
public class Product {
    @Id
    int productId;
    String productName,description;
    public Product() {
    }
    public Product(int productId,String productName, String description) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
