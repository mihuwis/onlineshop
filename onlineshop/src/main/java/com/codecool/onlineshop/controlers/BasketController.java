package com.codecool.onlineshop.controlers;

import java.util.List;
import java.util.Iterator;

import com.codecool.onlineshop.model.Basket;
import com.codecool.onlineshop.model.Product;

public class BasketController {

    private Basket basket = new Basket();

    public void createNewBasket() {
        Basket newBasket = new Basket();
        this.basket = newBasket;
    }

    public void removeProduct(Product product) {
        basket.removeProduct(product);
    }

    public List<Product> getProductsInBasket() {
        return basket.getProducts();
    }

    public void addProduct(Product product) {
        basket.addProduct(product);
    }

    public Iterator<Product> getProductIterator() {
        return basket.getIterator();
    }
}
