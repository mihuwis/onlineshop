package com.codecool.onlineshop.model;

import com.codecool.onlineshop.controlers.IDGenerator;

public class ProductCategory {
    
    String name;
    Integer ID;
    IDGenerator idGenerator = new IDGenerator();
    
    public ProductCategory() {}

    public ProductCategory(String name) {
        this.name = name;
        this.ID = idGenerator.generateID();
    }

    public String getCategoryName() {
        return name;
    }

    public Integer getID() {
        return ID;
    }
}
