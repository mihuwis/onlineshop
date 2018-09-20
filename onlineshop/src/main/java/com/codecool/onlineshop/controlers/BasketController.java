package com.codecool.onlineshop.controlers;

import java.util.ArrayList;
import java.util.List;

import com.codecool.onlineshop.model.Basket;
import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.model.ProductIterator;

public class BasketController {

    private Basket basket = new Basket();
    private List<Product> productList = new ArrayList<>();
    ProductIterator productIterator = basket.getIterator();

    public BasketController() {

        this.productList = basket.getProductList();
    }

    public List<Product> removeProduct(Product product) {
        productList.remove(product);
        return productList;
    }

    public List<Product> getAllProductsList() {
        return productList;
    }

    public void addProduct() {
        if (productIterator.hasNext())
            productList.add(productIterator.next());
    }

}