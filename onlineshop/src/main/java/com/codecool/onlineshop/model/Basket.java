package com.codecool.onlineshop.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basket{

    private List<Product> productList = new ArrayList<Product>();
    private ProductIterator productIterator = new ProductIterator();
    private Iterator iterator;

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product){
        productList.add(product);
    }



    
}