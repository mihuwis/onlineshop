package com.codecool.onlineshop.model;

import java.util.List;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import com.codecool.onlineshop.controlers.IDGenerator;

public class Product {

    private static List<Product> productList = new ArrayList<Product>();
    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Integer ID;
    private IDGenerator idGenerator = new IDGenerator();

    public Product() {
    }

    public Product(String name, Float defaultPrice, ProductCategory productCategory) {
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.productCategory = productCategory;
        this.ID = generateID();
        productList.add(this);
    }


    private Integer generateID()  {
        
        return idGenerator.generateID();
        
       
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public List<Product> getAllProductsBy(ProductCategory productCategory) {
        List<Product> productsOfCategory = new ArrayList<Product>();

        for (Product product : productList) {
            if (isProductTypeOfCategory(product, productCategory)) {
                productsOfCategory.add(product);
            }
        }
        return productsOfCategory;
    }

    public Integer getProductId() {
        return ID;
    }

    public String getProductName() {
        return name;
    }
    
    public Float getProductPrice() {
        return defaultPrice;
    }

    public Integer getProductCategoryId() {
        return productCategory.getID();
    }

    public String getCategoryName() {
        return productCategory.getCategoryName();
    }

    private boolean isProductTypeOfCategory(Product product, ProductCategory productCategory) {
        return product.getProductCategoryId() == productCategory.getID();
    }

    @Override
    public String toString() {
        return String.format("ID:%d,name:%s,defaultprice:%.2d", ID, name, defaultPrice);
    }
}
