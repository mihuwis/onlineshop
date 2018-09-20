package com.codecool.onlineshop.model;

import java.util.Iterator;
import java.util.List;

public class ProductIterator implements Iterator<Product> {

    private List<Product> productList;
    private int currentIndex = 0;

    public ProductIterator(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < productList.size() && productList.get(currentIndex) != null;
    }

    @Override
    public Product next() {
        return productList.get(currentIndex++);
    }
}
