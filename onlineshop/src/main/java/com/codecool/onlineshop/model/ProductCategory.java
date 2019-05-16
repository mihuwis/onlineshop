package com.codecool.onlineshop.model;

import com.codecool.onlineshop.controlers.IDGenerator;

public class ProductCategory {
    
    String name;
    Integer ID;
    IDGenerator idGenerator = new IDGenerator();
    
    public ProductCategory() {}

    public ProductCategory(String name) {
        this.name = name;
        try{
        this.ID = idGenerator.generateID();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getCategoryName() {
        return name;
    }

    public Integer getID() {
        return ID;
    }
}
