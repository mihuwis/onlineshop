package com.codecool.onlineshop.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basket{

    private List<Product> productList = new ArrayList<Product>();

    public List<Product> getProducts() {
        return productList;
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public Iterator<Product> getIterator(){
        return new ProductIterator(productList);
    }
}
