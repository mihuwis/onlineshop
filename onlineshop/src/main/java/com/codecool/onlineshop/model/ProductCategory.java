package com.codecool.onlineshop.model;

public class ProductCategory {
    
    String name;
    Integer ID;
    
    public ProductCategory() {}

    public ProductCategory(String name) {
        this.name = name;
        this.ID = generateID();
    }

    Integer generateID() {
        UUID uuid = UUID.randomUUID();
        return (Integer)uuid.toString();
    }

    public String getCategoryName() {
        return name;
    }

    public Integer getID() {
        return ID;
    }
}
