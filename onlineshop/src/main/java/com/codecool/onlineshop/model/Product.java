package com.codecool.onlineshop.model;

import java.util.List;
import java.util.ArrayList;

public class Product {

    private static List<Product> productList = new ArrayList<>();
    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Integer ID;

    public Product(){}

    public Product(String name, Float defaultPrice, ProductCategory productCategory) {
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.productCategory = productCategory;
        this.ID = generateID();
        productList.add(this);
    }

    private Integer generateID() {
        UUID uuid = UUID.randomUUID();
        return (Integer)uuid.toString();
    }

    public ArrayList<Product> getAllProducts() {
        return productList;
    }

    public ArrayList<Product> getAllProductsBy(ProductCategory productCategory) {
        List<Product> productsOfCategory = new ArrayList<>();

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
