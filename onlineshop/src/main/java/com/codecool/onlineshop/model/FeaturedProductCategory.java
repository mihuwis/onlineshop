package com.codecool.onlineshop.model;

import java.util.Date;
import com.codecool.onlineshop.controlers.IDGenerator;

public class FeaturedProductCategory extends ProductCategory {
    
    private Date expirationDate;

    public FeaturedProductCategory(String name, Date expirationDate) {
        super.name = name;
        super.ID = super.idGenerator.generateId();
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

}
