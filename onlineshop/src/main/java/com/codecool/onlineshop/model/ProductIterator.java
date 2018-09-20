package com.codecool.onlineshop.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductIterator implements Iterator {

    private List<Product> productList = new ArrayList<Product>();
    private int currentIndex = 0;

    @Override
    public boolean hasNext() {
        return currentIndex < productList.size() && productList.get(currentIndex) != null;
    }

    @Override
    public Product next() {
        return productList.get(currentIndex++);
    }

}