package com.codecool.onlineshop.model;

import java.util.Date;

public class FeaturedProductCategory extends ProductCategory {
    
    private Date expirationDate;

    public FeaturedProductCategory(String name, Date expirationDate) {
        super.name = name;
        super.ID = super.generateID();
    }

    public Date getExpirationDate() {
        return getExpirationDate();
    }

}
